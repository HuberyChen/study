package pratice.enumeration;

/**
 * @author hubery.chen
 */
public enum VendorConfigurationType {
    FI("FI", "Full Inventory Feed", "Missing Full Inventory Feed"),

    PI("PI", "Partial Inventory Feed", "Missing Partial Inventory Feed"),

    OR("OR", "Order Feed", "Orders Not Retrieved"),

    ORR("ORR", "Order Response Feed", "Order Responses Missing"),

    SN("SN", "Shipment Notification Feed", "Excessive Delayed Shipments"),

    IV("IV", "Invoicing Feed", "Missing Invoices");

    private String type;
    private String typeInfo;
    private String violationMessage;

    private VendorConfigurationType(String type, String typeInfo, String violationMessage) {
        this.type = type;
        this.typeInfo = typeInfo;
        this.violationMessage = violationMessage;
    }

    public String getType() {
        return type;
    }

    public String getTypeInfo() {
        return typeInfo;
    }

    public String getViolationMessage() {
        return violationMessage;
    }
}
