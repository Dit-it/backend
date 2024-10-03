package com.example.backend.util;

import org.locationtech.jts.geom.GeometryFactory; // JTS의 GeometryFactory
import org.locationtech.jts.geom.Geometry; // JTS의 Geometry
import org.locationtech.jts.io.WKTReader; // JTS의 WKTReader

public class GeometryConverter {

    private final GeometryFactory geometryFactory;

    public GeometryConverter() {
        this.geometryFactory = new GeometryFactory();
    }

    public Geometry convert(org.geolatte.geom.Geometry geolatteGeometry) {
        if (geolatteGeometry == null) {
            return null;
        }

        // WKT로 변환 후 JTS Geometry로 변환
        try {
            String wkt = geolatteGeometry.toString().substring(10); // Geolatte Geometry를 WKT 문자열로 변환
            WKTReader reader = new WKTReader(geometryFactory);
            return reader.read(wkt); // WKT 문자열을 JTS Geometry로 변환
        } catch (Exception e) {
            throw new RuntimeException("Geometry conversion failed", e);
        }
    }
}
