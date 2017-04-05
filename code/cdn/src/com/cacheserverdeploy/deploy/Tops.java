package com.cacheserverdeploy.deploy;

import java.util.ArrayList;

public class Tops implements Comparable<Tops>
{
    public Tops(int i)
    {
        consumer=0;
        count=i;
        lines=new ArrayList<Line>();
        consumerNumber=-1;
        server=false;
        visit = false;
        plan=new ArrayList<Plan>();
    }

    ArrayList<Line> lines;
    public int consumer;//если есть связь с потребителем то тут будет больше 0
    public int count;
    public int consumerNumber;
    public boolean server;
    public boolean visit;
    public ArrayList<Plan> plan;


    public int getHeftTop()
    {
        int sum=0;
        for(int i=0; i<lines.size();i++)
        {
            sum=sum+lines.get(i).getHeft();
        }
        return  sum;
    }

    public void recieve(Plan p)
    {
        Plan plan = p;
        plan.top.add(this.count);
        this.plan.add(plan);
    }

    public void recieve(Plan p, int mass)
    {
        Plan plan = p.getCopy(mass);
        recieve(plan);
    }


    public boolean getBool()
    {
        return lines.size()<2&&this.consumerNumber==-1;
    }

    public  int getCost()
    {
        int sum=0;
        for(int i=0;i<lines.size();i++)
        {
            sum=sum+lines.get(i).getCost();
        }
        return sum;
    }

    public int compareTo(Tops o) {

        return o.getHeftTop()-this.getHeftTop();
    }
    public boolean isEmpty(Tops t)
    {
        if(this.count==t.count)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean benefitsMovement(int sss)
    {
       return true;
    }
}
