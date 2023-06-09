package com.ruoyi.system.domain.AssemblyPojo.Resource;

import com.ruoyi.system.domain.AssemblyPojo.Knowledge.TypicalKnowledge.Process.TypicalProcedure;
import com.ruoyi.system.domain.AssemblyPojo.Knowledge.TypicalKnowledge.Process.TypicalProcess;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Node("EquipmentResource")
public class EquipmentResource extends AssemblyResource{

    @Property(name = "Capacity")
    private Map<String,String> equipmentCapacity;

    @Property(name = "Power")
    private double equipmentPower;

    @Property(name = "Price")
    private double equipmentPrice;

    @Property(name = "productionDate")
    private Date productionDate;

    @Property(name = "manufacturer")
    private String manufacturer;

    @Property(name = "Size")
    private String equipmentSize;

    @Property(name = "State")
    private String equipmentState;

    @Property(name = "depreciationRate")
    private double depreciationRate;

    @Property(name = "loadRate")
    private double loadRate;

    @Property(name = "Attentions")
    private List<String>  Attentions;

    @Property(name = "principle")
    private String principle;

    @Relationship(type = "hasInstallTool" , direction = Relationship.Direction.OUTGOING)
    private Set<AssemblyResource> installTools;

    @Relationship(type = "hasSubEquipments" , direction = Relationship.Direction.OUTGOING)
    private Set<AssemblyResource> subEquipments;

    @Relationship(type = "hasSuitableTool" , direction = Relationship.Direction.OUTGOING)
    private Set<AssemblyResource> suitableTools;

    @Relationship(type = "hasUnSuitableTool" , direction = Relationship.Direction.OUTGOING)
    private Set<AssemblyResource> unsuitableTools;

    @Relationship(type = "hasSuitableProcess" , direction = Relationship.Direction.OUTGOING)
    private Set<TypicalProcess> suitableProcesses;

    @Relationship(type = "hasSuitableProcedure" , direction = Relationship.Direction.OUTGOING)
    private Set<TypicalProcedure> suitableProcedures;

    @Relationship(type = "hasUnSuitableProcess" , direction = Relationship.Direction.OUTGOING)
    private Set<TypicalProcess> unsuitableProcesses;

    @Relationship(type = "hasUnSuitableProcedure" , direction = Relationship.Direction.OUTGOING)
    private Set<TypicalProcedure> unsuitableProcedures;

}
