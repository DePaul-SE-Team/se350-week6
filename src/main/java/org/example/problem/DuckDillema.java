package org.example.problem;

public class DuckDillema {
    public static void main (String [] args){

    }
}

abstract class Duck {
    abstract String swim();
    abstract String quack();
}

class SwimmingDuck extends Duck {
    @Override
    String swim() {
        return("can swim");
    }

    @Override
    String quack() {
        return("can quack");
    }
}

class FloatingDuck extends Duck {
    @Override
    String swim() {
        return("can float");
    }

    @Override
    String quack() {
        return("can squeak");
    }
}

class Mallard extends SwimmingDuck {
    // reuse
}

class RedHead extends SwimmingDuck {
    // reuse
}

class Rubber extends SwimmingDuck {
    @Override
    String swim() {
        return("can float");
    }

    @Override
    String quack() {
        return("can squeak");
    }
}

class Decoy extends SwimmingDuck {
    @Override
    String quack() {
        // does nothing
        return "";
    }
}
