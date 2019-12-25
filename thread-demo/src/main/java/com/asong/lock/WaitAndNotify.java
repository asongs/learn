package com.asong.lock;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Asong
 * @title: WaitAndNotify
 * @date 2019-12-25 17:26
 */
public class WaitAndNotify {


    /**
     *  条件list
     */
    private List<Object> waitList = new ArrayList<>();

    synchronized void apply(Object from, Object to){
        while (waitList.contains(from) || waitList.contains(to)){
            //条件不成立
            try {
                //等待
                this.wait();
            }catch (InterruptedException e){

            }
            waitList.add(from);
            waitList.add(to);
        }
    }

    synchronized void free(Object from, Object to){
        //移除条件 并且通知唤醒所有等待线程
        waitList.remove(from);
        waitList.remove(to);
        notifyAll();
    }

    public static void main(String[] args) {
        WaitAndNotify waitAndNotify = new WaitAndNotify();

    }

    static class Account{

        private Integer banalce;

        public Account(Integer banalce){
            this.banalce = banalce;
        }

        public void transactionToTarget(Integer money, Account target){

        }
    }
}
