package de.dlh.lhind.product.domain.persistence.model;

public enum MediaType {
    IMAGE("image"),
    VIDEO("video");

    private final String type;

    MediaType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static MediaType fromString(String type) {
        for (MediaType mediaType : MediaType.values()) {
            if (mediaType.type.equalsIgnoreCase(type)) {
                return mediaType;
            }
        }
        throw new IllegalArgumentException("Unknown media type: " + type);
    }
}
