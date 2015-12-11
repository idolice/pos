package com.thoughtworks.pos.domain;

/**
 * Created by idolice on 15-12-8.
 */
public class AllImformationItem {
    public  String barcode;
    public double price;
    public  Integer count;
    public Integer discount;
    public   boolean halfornot;

    public AllImformationItem( ){
        this.barcode=null;
        this.price = 0;
        this.count = 0;
        this.discount = 0;
        this.halfornot = false;
    }

   public double getallprice(AllImformationItem allImformationItem){
       double allprice=0;
       if(allImformationItem.halfornot==true){
           if (allImformationItem.discount!=0){
               if (allImformationItem.count>1){
                   int m=allImformationItem.count/2;
                   allprice=m*gethalfprice(allImformationItem.price)+(allImformationItem.count-m)*getdiscountprice(allImformationItem.price,allImformationItem.discount);
                   return allprice;
               }
               else {
                   allprice=allImformationItem.count*getdiscountprice(allImformationItem.price,allImformationItem.discount);
                   return allprice;
               }
           }
           else if (allImformationItem.count>1){
               int m=allImformationItem.count/2;
               allprice=m*gethalfprice(allImformationItem.price)+(allImformationItem.count-m)*allImformationItem.price;
               return allprice;
           }
           else {
               allprice=allImformationItem.count*allImformationItem.price;
               return allprice;
           }
       }
       else if (allImformationItem.discount!=0){
           allprice=allImformationItem.count*getdiscountprice(allImformationItem.price,allImformationItem.discount);
           return allprice;
       }
       else {
           allprice=allImformationItem.count*allImformationItem.price;
           return allprice;
       }
   }

    private double getdiscountprice(double price,Integer discount){
        return price*discount/100;
    }

    private double gethalfprice(double price){
        return price/2;
    }
}
