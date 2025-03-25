package com.urverse.booking;
public class BookingDetails {
   private String movies,theatres,timings,seatsno,image;
   private int price,id;
   private String[] aseatsno;
   private String[] bseatsno;
   private String[] cseatsno;
   public BookingDetails(){}
   public void setmovies(String movies){
       this.movies=movies;
   }
    public String getmovies(){
        return this.movies;
    }
     public void setimage(String image){
       this.image=image;
   }
    public String getimage(){
        return this.image;
    }
    public void setseatsno(String seatsno){
       this.seatsno=seatsno;
   }
    public String getseatsno(){
        return this.seatsno;
    }
     public void setprice(int price){
       this.price=price;
   }
    public int getprice(){
        return this.price;
    }
      public void setid(int id){
       this.id=id;
   }
    public int getid(){
        return this.id;
    }
    public void settimings(String timings){
       this.timings=timings;
   }
    public String gettimings(){
        return this.timings;
    }
    public void settheatres(String theatres){
        this.theatres=theatres;
    }
    public String gettheatres(){
        return this.theatres;
    }
    public void setaseatsno(String[] aseatsno){
        this.aseatsno=aseatsno;
    }
    public String[] getaseatsno(){
        return this.aseatsno;
    }
    public void setbseatsno(String[] bseatsno){
        this.bseatsno=bseatsno;
    }
    public String[] getbseatsno(){
        return this.bseatsno;
    }
    public void setcseatsno(String[] cseatsno){
        this.cseatsno=cseatsno;
    }
    public String[] getcseatsno(){
        return this.cseatsno;
    }
   
}
