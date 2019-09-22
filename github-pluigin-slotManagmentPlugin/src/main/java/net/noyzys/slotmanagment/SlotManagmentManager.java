package net.noyzys.slotmanagment;

public final class SlotManagmentManager {

    private final SlotManagmentPlugin plugin;
    private int slot_limit = 1000;

    public SlotManagmentManager(SlotManagmentPlugin plugin) {
        this.plugin = plugin;
    }

    public int getSlot_limit() {
        return slot_limit;
    }

    public void setSlot_limit(int slot_limit) {
        this.slot_limit = slot_limit;
    }
}
