package com.cacheserverdeploy.deploy;


import java.util.ArrayList;
import java.util.Collections;

public class Deploy
{
    static ArrayList<Tops> vertex;
    static int costServer;
    static ArrayList<Tops> consumer;
    static ArrayList<Tops> server;
    static ArrayList<Tops> base;
    /**
     * todo
     * 
     * @return  caseouput info
     * @see [huawei]
     */

    public static void creatNewTops(int n)
    {
        for(int i=0;i<n;i++)
        {
            Tops t = new Tops(i);
            vertex.add(t);
        }
    }

    public static int[] parseStringLine(String string)
    {
        int[] arr = new int[4];
        int qwe=0;
        int j=0;
        for(int i=0;i<string.length();i++)
        {
            if(' '== string.charAt(i))
            {
                arr[j]=Integer.parseInt(string.substring(qwe,i));
                j++;
                qwe=i+1;
            }
        }
        arr[j]=Integer.parseInt(string.substring(qwe,string.length()));
        return arr;

    }


    public static void deleteTops()
    {
        ArrayList<Tops>asd = new ArrayList<Tops>();
        for(int i = 0; i< vertex.size(); i++)
        {
            if(vertex.get(i).getBool())
            {
                asd.add(vertex.get(i));
            }
        }
        try {
            for (Tops t : asd) {
                for (int i = 0; i < t.lines.size(); i++) {
                    Line line = t.lines.get(i);
                    line.getOthaerTop(t).lines.remove(line);
                    Tops tops = line.getOthaerTop(t);
                    if(tops.getBool())
                    {
                        asd.add(tops);
                    }
                }
                vertex.remove(t);
            }
        }catch (Exception e)
        {

        }
    }

    public static int getSizeLine(ArrayList<Line> line, int size, Tops tops)
    {
        int min = 0;
        for(int i = 0 ;i<line.size();i++)
        {
            if(!line.get(i).getOthaerTop(tops).visit)
            {
                min = min + line.get(i).getHeft();
                if (min >= size)
                {
                    return i;
                }
            }
        }
        return -1;
    }


//    public static void lookNextTop()
//    {
//        for(Tops tops: consumer)
//        {
//            int consumer =0;
//            for(Plan p : tops.plan)
//            {
//                consumer = consumer+p.use;
//            }
//            int numberLine = getSizeLine(tops.lines,consumer);
//            if(numberLine!=-1)
//            {
//                int k=0;
//                for (int i = 0; i <= numberLine; i++)
//                {
//                    for(int j = k;j<tops.plan.size();j++)
//                    {
//                        if(tops.plan.get(j).use<tops.lines.get(i).getHeft())
//                        {
//
//                            Tops tops2=tops.lines.get(i).getOthaerTop(tops);
//                            tops.plan.get(j).top.add(tops2.count);
//                            tops2.plan.add(tops.plan.get(j));
//                            tops.lines.get(i).use+=tops.plan.get(j).use;
//                            tops.plan.remove(tops.plan.get(j));
//                            i--;
//                            break;
//                        }
//                        if(tops.plan.get(j).use==tops.lines.get(i).getHeft())
//                        {
//                            Tops tops2=tops.lines.get(i).getOthaerTop(tops);
//                            tops.plan.get(j).top.add(tops2.count);
//                            tops2.plan.add(tops.plan.get(j));
//                            tops.lines.get(i).use+=tops.plan.get(j).use;
//                            tops.plan.remove(tops.plan.get(j));
//                            break;
//                        }
//                        if(tops.plan.get(j).use>tops.lines.get(i).getHeft())
//                        {
//                            Tops tops2=tops.lines.get(i).getOthaerTop(tops);
//                            Plan plan = tops.plan.get(j).getCopy(tops.lines.get(i).getHeft());
//                            plan.top.add(tops2.count);
//                            tops2.plan.add(plan);
//                            tops.lines.get(i).use+=plan.use;
////                            tops.plan.remove(tops.plan.get(j));
//                            break;
//                        }
//                    }
//                }
//            }
//
//        }
//    }

    public static void passPlan(Tops top)
    {
        for (Tops tops: base)
        {
            if(top.isEmpty(tops))
            {
                return;
            }
        }
        Collections.sort(top.lines);
        top.visit=true;
        ArrayList<Plan> plen = new ArrayList<Plan>();
        int massPlan=0;
        for(Plan p: top.plan)
        {
            massPlan+=p.use;
        }
        int lineCount = getSizeLine(top.lines,massPlan,top);
        if(lineCount==-1)
        {
            server.add(top);
            return;
        }
        int k =0;

            for (int i = 0; i <= lineCount; i++) {

                for (int j = 0; j < top.plan.size(); j++) {
                    Line line;
                    try {
                        line = top.lines.get(i);

                    if (line.getHeft() == 0) {
                        continue;
                    }
                    if (line.getHeft() > top.plan.get(j).use) {
                        Tops tops2 = line.getOthaerTop(top);
                        tops2.recieve(top.plan.get(j));
                        line.use += top.plan.get(j).use;
                        plen.add(top.plan.get(j));
                        consumer.add(tops2);
                        continue;
                    }
                    if (line.getHeft() == top.plan.get(j).use) {
                        Tops tops2 = line.getOthaerTop(top);
                        tops2.recieve(top.plan.get(j));
                        line.use += top.plan.get(j).use;
                        plen.add(top.plan.get(j));
                        if (i < lineCount) {
                            i++;
                        }
                        consumer.add(tops2);
                        continue;
                    }
                    if (line.getHeft() < top.plan.get(j).use) {
                        Tops tops2 = line.getOthaerTop(top);
                        tops2.recieve(top.plan.get(j), line.getHeft());
                        line.use += line.getHeft();
                        if (i < lineCount)
                        {
                        i++;}
                        j--;
//                    if(i>lineCount)
//                    {
//                        break;
//                    }
//                    line = top.lines.get(i);
                        consumer.add(tops2);
                        continue;
                    }
                    }catch (Exception e)
                    {
                        int qweqwe=0;
                    }
                    }

            }

        top.plan.clear();
    }


    public static void sortLines()
    {
        for(int i=0; i<vertex.size(); i++)
        {
            Collections.sort(vertex.get(i).lines);
        }
    }


    public static String[] deployServer(String[] graphContent)
    {
        server= new ArrayList<Tops>();
        base= new ArrayList<Tops>();
        int minPower =0;
        int arr[]=parseStringLine(graphContent[0]);
        consumer = new ArrayList<Tops>();
        vertex = new ArrayList<Tops>();
        creatNewTops(arr[0]);
        int lines=arr[1];
        int pot=arr[2];
        costServer=parseStringLine(graphContent[2])[0];
        for(int i = 4;i<4+lines;i++)
        {
            arr=null;
            arr=parseStringLine(graphContent[i]);
            Line l = new Line(vertex.get(arr[0]), vertex.get(arr[1]),arr[2],arr[3]);
            vertex.get(arr[0]).lines.add(l);
            vertex.get(arr[1]).lines.add(l);
        }
        for(int i=lines+5;i<lines+pot+5;i++)
        {

            arr=null;
            arr=parseStringLine(graphContent[i]);
            vertex.get(arr[1]).consumerNumber=arr[0];
//            vertex.get(arr[1]).plan.top.add(arr[0]);
//            vertex.get(arr[1]).plan.top.add(arr[1]);
            vertex.get(arr[1]).consumer=arr[2];
//            vertex.get(arr[1]).plan.use=arr[2];
            Plan p = new Plan();
            p.use=arr[2];
            p.consumerNumber=arr[0];
            p.top.add(arr[1]);
            vertex.get(arr[1]).plan.add(p);
            minPower=minPower+arr[2];
            consumer.add(vertex.get(arr[1]));

        }
        Collections.sort(vertex);
        deleteTops();
        int w = getMinTops(minPower);
        if(w!=-1)
        {
            for(int i =0;i<=w;i++)
            {
                base.add(vertex.get(i));
            }
        }
        sortLines();
        ArrayList<Tops> copyConsumer;
        copyConsumer = new ArrayList<Tops>();
        while (consumer.size()!=0)
        {
            copyConsumer.clear();
            copyConsumer.addAll(consumer);
//            Collections.copy(copyConsumer,consumer);
            consumer.clear();
            for (Tops tops: copyConsumer)
            {
                passPlan(tops);
            }
        }
        server.clear();
        for (Tops t:vertex)
        {
            if(t.plan.size()>0)
            {
                server.add(t);
            }
        }
        int road = 0;
        for (Tops tops: server)
        {
            road+=tops.plan.size();
        }
        String[] govno = new String[road+2];
//        ArrayList<String> out = new ArrayList<String>();
//        out.add(Integer.toString(road) + "\n\n");
        govno[0]=Integer.toString(road)+"\n";
        govno[1]="\n";
        int i=2;
        for (Tops tops: server)
        {
            for (Plan plan: tops.plan)
            {
                govno[i]=plan.toString();
                i++;
//                out.add(plan.toString());
            }
        }
//        String[] qweqweewew= (String[]) out.toArray();

        return govno;
    }



    private static int getMinTops(int minPower)
    {
        int mas=0;
        for(int i =0;i<vertex.size();i++)
        {
            for (Line l: vertex.get(i).lines)
            {
                mas+=l.getHeft();
            }
            if(mas>=minPower)
            {
                return i;
            }
        }
        return -1;
    }


}
