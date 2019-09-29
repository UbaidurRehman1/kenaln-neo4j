package com.ubaid.neo4j.kenalan;

import com.ubaid.neo4j.kenalan.entity.*;
import com.ubaid.neo4j.kenalan.entity.Object;
import com.ubaid.neo4j.kenalan.repository.*;
import com.ubaid.neo4j.kenalan.service.def.ObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories("com.ubaid.neo4j.kenalan.repository")
@EntityScan(basePackages = "com.ubaid.neo4j.kenalan.entity")
public class KenalanApplication implements CommandLineRunner
{

    @Autowired
    private ObjectService objectService;

    @Autowired
    private AssemblyRepo assemblyRepo;

    @Autowired
    private MaterialRepo materialRepo;

    @Autowired
    private PartRepo partRepo;

    @Autowired
    private ManufacturerRepo manufacturerRepo;

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private MaintinanceEventRepo maintinanceEventRepo;

    @Autowired
    private MaintinanceRepo maintenanceRepo;

    @Autowired
    private AssignmentRepo assignmentRepo;

    public static void main(String[] args) {
        SpringApplication.run(KenalanApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Assembly assembly = new Assembly();
        assembly.setName("Assembly1");

        Manufacturer manufacturer1 = new Manufacturer();
        manufacturer1.setName("Greno Industries, Inc.");

        Material material = new Material();
        material.setName("Steel A286");

        Part part = new Part();
        part.setName("Part");

        assemblyRepo.save(assembly);
        manufacturerRepo.save(manufacturer1);
        materialRepo.save(material);
        partRepo.save(part);

        Object object = new Object("12 Point Bolt ~ New", "LIS-AQgLTE3-18-247222", "8f98c6ee-44db-4e8f-8eb2-841ba825d901", "MA49457ZD-36");
        object.setIsAssembly(assembly);
        object.setIsMadeBy(manufacturer1);
        object.setIsMadeOf(material);
        object.setIsPart(part);


        Material material1 = new Material();
        material.setName("Aluminium");
        material.setMaterialID("Steel-1234");
        materialRepo.save(material);

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("MD&A");
        manufacturerRepo.save(manufacturer);


        Object object1 = new Object("Compressor shaft", "LIS-EBgSU3Y-18-298277", "aae7498e-946d-453f-8b78-6d070cb7fd0c", "BB35-32-84-P2");
        object1.setIsPart(part);
        object1.setIsPartOf(object);
        object1.setIsMadeOf(material);
        object1.setIsMadeBy(manufacturer);
        objectService.save(object);

        MaintinanceEvent maintinanceEvent = new MaintinanceEvent();
        maintinanceEvent.setAssignmentNumber(3L);
        maintinanceEvent.setObject(object1);
        maintinanceEventRepo.save(maintinanceEvent);

        Person person = new Person();
        person.setName("John Smith");
        person.setMaintinanceEvent(maintinanceEvent);
        personRepo.save(person);

        Assignment assignment = new Assignment();
        assignment.setName("Assg1");
        assignment.setApprovedBy("Mr. Halland");
        assignment.setIsDoingBy(person);
        assignmentRepo.save(assignment);


        Maintenance maintenance = new Maintenance();
        maintenance.setName("12 Point Bolt");
        maintenance.setSerialNumber("skldfjskldfj");
        maintenance.setIsAssigned(assignment);
        maintenanceRepo.save(maintenance);


    }
}
