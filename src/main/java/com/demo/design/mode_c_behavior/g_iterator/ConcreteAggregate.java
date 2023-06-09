package com.demo.design.mode_c_behavior.g_iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ConcreteAggregate: 具体聚合类
 */
public class ConcreteAggregate implements Aggregate{
    List<String> list = new ArrayList<String>(Arrays.asList("買","房","技"));

    @Override
    public Iterator CreateIterator() {
        InnerIterator innerIterator = new InnerIterator();
        return innerIterator;
    }

    /**
     * ConcreteIterator: 具体迭代器
     */
    public class InnerIterator implements Iterator{
        private  int currIndex ;

        public InnerIterator() {
            this.currIndex=0;
        }

        @Override
        public String first() {
            return list.get(0);
        }

        @Override
        public String next() {
            return list.get(currIndex ++);
        }

        @Override
        public boolean isDone() {
            if(list.size() == currIndex){
                return true;
            }
            return false;
        }

        @Override
        public String currentItem() {
            return list.get(currIndex);
        }
    }


}