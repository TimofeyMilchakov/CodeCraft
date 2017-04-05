package com.cacheserverdeploy.deploy;

import java.util.ArrayList;

/**
 * Created by tttt on 03.04.2017.
 */
public class Plan
{
//    public Tops tops;
    public int use;
    public ArrayList<Integer> top;
    public int consumerNumber;
    public int packageCost;

    public Plan()
    {
        consumerNumber=0;
        use=0;
        top=new ArrayList<Integer>();
        packageCost=0;
    }

    public String toString()
    {
        StringBuilder wqqe = new StringBuilder();
        for (int i=top.size()-1;i>=0;i--)
        {
            wqqe.append(Integer.toString(top.get(i)));
            wqqe.append(" ");
        }
        wqqe.append(Integer.toString(consumerNumber));
        wqqe.append(" ");
        wqqe.append(Integer.toString(use));
        wqqe.append("\n");
        return wqqe.toString();
    }

    public void addPackageCost( int use, int cost)
    {
        packageCost+=use*cost;
    }

    public boolean benefitsMovement(int sss)
    {
        if(packageCost<sss)
        {
            return true;
        }
        return false;
    }

    public Plan getCopy(int mas)
    {
        this.use=this.use-mas;
        Plan plan = new Plan();
        plan.top.addAll(this.top);
//        Collections.copy(plan.top,this.top);
        plan.use=mas;
        plan.consumerNumber=this.consumerNumber;
        return plan;
    }

//    public Plan( int u)
//    {
//        top=new ArrayList<Integer>();
//        use=u;
//
//    }
}
