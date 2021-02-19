
/*
ChainOfProcess of responsibility pattern is used to achieve loose coupling in software design where a request
from the client is passed to a chain of objects to process them. Later, the object in the chain will
decide themselves who will be processing the request and whether the request is required to be sent
to the next object in the chain or not.
*/


package com.rakib.java_design_pattern.behavioral.chain_of_responsibility;

class ChainOfProcess {
    Processor chain;

    public ChainOfProcess() {
        buildChain();
    }

    private void buildChain() {
        chain = new NegativeProcessor(new ZeroProcessor(new PositiveProcessor(null)));
    }

    public void process(Integer request) {
        chain.process(request);
    }

}

abstract class Processor {
    private Processor processor;

    public Processor(Processor processor) {
        this.processor = processor;
    }
    public void process(Integer request) {
        if (processor != null)
            processor.process(request);
    }
}


class NegativeProcessor extends Processor {
    public NegativeProcessor(Processor processor) {
        super(processor);
    }

    public void process(Integer request) {
        if (request < 0) {
            System.out.println("NegativeProcessor : " + request);
        } else {
            super.process(request);
        }
    }
}

class ZeroProcessor extends Processor {
    public ZeroProcessor(Processor processor) {
        super(processor);
    }

    public void process(Integer request) {
        if (request == 0) {
            System.out.println("ZeroProcessor : " + request);
        } else {
            super.process(request);
        }
    }
}

class PositiveProcessor extends Processor {

    public PositiveProcessor(Processor processor) {
        super(processor);
    }

    public void process(Integer request) {
        if (request > 0) {
            System.out.println("PositiveProcessor : " + request);
        } else {
            super.process(request);
        }
    }
}

public class ChainOfResponsibilityDesignPattern {
    public static void main(String[] args) {
        ChainOfProcess chain = new ChainOfProcess();
        //Calling chain of responsibility
        chain.process(90);
        chain.process(-50);
        chain.process(0);
        chain.process(91);
    }
}
