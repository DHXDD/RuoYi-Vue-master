package com.ruoyi.system.domain.AssemblyPojo.Knowledge.Prescription.Interface;

import com.ruoyi.system.domain.AssemblyPojo.Knowledge.MaterialKnowledge.Interface.MaterialInterface;

public interface hasMaterialElementInterface {

    Long getId();

    double getPercentage();

    MaterialInterface getMaterial();
}
