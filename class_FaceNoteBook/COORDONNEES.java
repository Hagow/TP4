package iut.unice.iut.info.methodo.s3a;

import com.sun.javafx.geom.Point2D;

public class COORDONNEES
{
    int x;
    int y;
    
    public static float Distance (COORDONNEES c1, COORDONNEES c2)
    {
        return Point2D.distance(c1.x, c1.y, c2.x, c2.y);
    }
}