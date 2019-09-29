package com.ubaid.neo4j.kenalan;

import com.ubaid.neo4j.kenalan.entity.*;
import com.ubaid.neo4j.kenalan.entity.Object;
import com.ubaid.neo4j.kenalan.poi.dao.def.ManufacturerDAO;
import com.ubaid.neo4j.kenalan.poi.dao.def.MaterialDAO;
import com.ubaid.neo4j.kenalan.poi.dao.def.NodeDAO;
import com.ubaid.neo4j.kenalan.poi.dao.def.ObjectDAO;
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

    }
}
