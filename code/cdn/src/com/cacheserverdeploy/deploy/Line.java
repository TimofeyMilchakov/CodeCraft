package com.cacheserverdeploy.deploy;

import java.util.ArrayList;

public class Line implements Comparable<Line>
{
    public Line(Tops tops1, Tops tops2, int heft, int cost)
    {
        this.tops1=tops1;
        this.tops2=tops2;
        this.heft=heft;
        this.cost=cost;
        this.use=0;
        plan=new ArrayList<Plan>();

    }
    public Tops tops1;
    public Tops tops2;
    private int heft;//вес ребра в Гб
    public int cost;//цена за один Гб
    public int use;
    public ArrayList<Plan> plan;
    public int getHeft()
    {
        return heft-use;
    }

    public int getCost()
    {
        return use*cost;
    }
    public Tops getOthaerTop(Tops t)
    {
        if(t.count==tops1.count)
        {
            return  tops2;
        }
        else
        {
            return tops1;
        }
    }

    public int compareTo(Line o)
    {
        if(this.cost==o.cost)
        {
            return o.getHeft()-this.getHeft();
        }
        return this.cost-o.cost;
    }
}
