package edu.gonzaga;

/***********************************************************************
 * 
 */
abstract class Material {

}

class Linen extends Material {

}

abstract class Metal extends Material {

}

class Nickel extends Metal {

}

class Silver extends Metal {

}

class Copper extends Metal {

}




/****************************************************************************
 * 
 */
public abstract class Money {
    protected Double denomenation = 0.0;
    protected String name = "";
    protected Material material;
}

class Bill extends Money {
    public Bill() {
        super();
        material = new Linen();
    }
}

class Dollar extends Bill {
    public Dollar() {
        super();
        denomenation = 1.0;
        name = "Dollar";
    }
}

class Benjamin extends Bill {
    public Benjamin() {
        super();
        denomenation = 100.0;
        name = "100 Dollar Bill";
    }
}

/*
 *  
 */
abstract class Coin extends Money {
    protected String obverse = "";
    protected String reverse = "";
    protected Double diameter_mm = 0.0;
    public Coin() {
        super();
    }
}

class LincolnMemorialCent extends Coin {
    public LincolnMemorialCent() {
        super();
        denomenation = 0.01;
        name = "Lincoln Memorial Cent";
        obverse = "Abraham Lincoln";
        reverse = "Lincoln Memorial";
        material = new Copper();
        diameter_mm = 19.0;
    }
}

class JeffersonWarNickel extends Coin {
    public JeffersonWarNickel() {
        super();
        denomenation = 0.05;
        name = "Jefferson War Nickel";
        obverse = "Thomas Jefferson";
        reverse = "Monticello";
        material = new Silver();
        diameter_mm = 21.21;
    }
}
