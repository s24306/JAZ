
package org.example.tools.geographies;

import org.example.tools.abstractions.IParse;
import org.example.model.Geography;

public class GeographyParser implements IParse<Geography> {
    @Override
    public Geography parse(String line) {
        String[] parts = line.trim().split(";");
        Geography geo = new Geography();
        geo.setId(Integer.parseInt(parts[0]));
        geo.setType(parts[1]);
        geo.setName(parts[2]);
        geo.setCode(parts[3]);
        String parentId = parts[4];
        if(parentId.equalsIgnoreCase("null")) return geo;
        geo.setParentId(Integer.parseInt(parentId));
        return geo;
    }
}
