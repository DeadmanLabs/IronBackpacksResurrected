package com.quantum.quantum_quarry.init;

import com.quantum.quantum_quarry.item.BackpackBasicItem;

public class ModItems {
    public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(QuantumQuarry.MODID);
    public static final DeferredItem<BackpackBasicItem> BACKPACK_BASIC = REGISTRY.register(
        "backpack_basic",
        Item::new
    );
}