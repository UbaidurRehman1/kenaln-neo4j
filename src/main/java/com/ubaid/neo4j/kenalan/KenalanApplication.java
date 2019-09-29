package com.ubaid.neo4j.kenalan;

import com.ubaid.neo4j.kenalan.entity.*;
import com.ubaid.neo4j.kenalan.entity.Object;
import com.ubaid.neo4j.kenalan.poi.dao.def.*;
import com.ubaid.neo4j.kenalan.poi.dao.imp.NodeTypeImp;
import com.ubaid.neo4j.kenalan.repository.*;
import com.ubaid.neo4j.kenalan.service.def.ObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

@SpringBootApplication
@EnableNeo4jRepositories("com.ubaid.neo4j.kenalan.repository")
@EntityScan(basePackages = "com.ubaid.neo4j.kenalan.entity")
public class KenalanApplication implements CommandLineRunner
{
    @Autowired
    private AssignmentRepo assignmentRepo;

    @Autowired
    ManufacturerDAO manufacturerDAO;

    @Autowired
    MaterialDAO materialDAO;

    @Autowired
    ObjectDAO objectDAO;

    @Autowired
    NodeDAO nodeDAO;

    @Autowired
    ManufacturerRepo manufacturerRepo;

    @Autowired
    MaterialRepo materialRepo;

    @Autowired
    PartRepo partRepo;

    @Autowired
    AssemblyRepo assemblyRepo;

    @Autowired
    ObjectRepository objectRepository;

    @Autowired
    NodeTypeRepo nodeTypeRepo;

    @Autowired
    PersonDAO personDAO;

    @Autowired
    AssignmentDAO assignmentDAO;

    @Autowired
    MaintenanceDAO maintenanceDAO;

    @Autowired
    PersonRepo personRepo;

    @Autowired
    MaintinanceRepo maintinanceRepo;


    public static void main(String[] args) {
        SpringApplication.run(KenalanApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Set<Manufacturer> manufacturers = manufacturerDAO.getManufacturer();
        Set<Material> materials = materialDAO.getMaterials();
        Set<NodeType> nodeTypes = nodeDAO.getParts();
        Set<Object> objects = objectDAO.getObjectsFromExcel();

        Iterator<Manufacturer> manufacturerIterator = manufacturers.iterator();
        Iterator<Material> materialIterator = materials.iterator();
        Iterator<NodeType> nodeTypeIterator = nodeTypes.iterator();
        Iterator<Object> objectIterator = objects.iterator();

        while (manufacturerIterator.hasNext()) {
            Manufacturer manufacturer = manufacturerIterator.next();
            manufacturerRepo.save(manufacturer);
        }

        while (materialIterator.hasNext()) {
            Material material = materialIterator.next();
            materialRepo.save(material);
        }

        while (nodeTypeIterator.hasNext()) {
            NodeType nodeType = nodeTypeIterator.next();
            nodeTypeRepo.save(nodeType);
        }

        while(objectIterator.hasNext()) {
            Object object = objectIterator.next();
            object.setIsMadeOf(materialRepo.findByName(object.getMaterialName()));
            object.setIsMadeBy(manufacturerRepo.findByName(object.getManufacturerName()));
            object.setNodeType(nodeTypeRepo.findByName(object.getNodeTypeName()));
            objectRepository.save(object);
        }

        Set<Person> personSet = personDAO.getPersons();
        List<Maintenance> maintenanceList = maintenanceDAO.getMaintenanceList();
        List<Assignment> assignments = assignmentDAO.getAssignmentList();

        Iterator<Person> personIterator = personSet.iterator();
        personRepo.saveAll(personSet);

        assert(maintenanceList != null);

        for (Maintenance maintenance : maintenanceList) {
            Object object = objectRepository.findByName(maintenance.getName());
            maintenance.setSerialNumber(object.getSerialNumber());
            maintenance.setUUID(object.getUUID());
            maintenance.setPartNumber(object.getPartNumber());
            maintinanceRepo.save(maintenance);
        }

        int counter = 0;
        for (Assignment assignment : assignments) {
            counter++;
            Person person = personRepo.findByName(assignment.getPersonName());
            Maintenance maintenance = maintinanceRepo.findByName(assignment.getPartName());
            assignment.setPerson(person);
            assignment.setMaintenance(maintenance);
            person.addAssignment(maintenance);
            personRepo.save(person);
            assignment.setId((long) counter);
            assignmentRepo.save(assignment);
        }

    }
}
