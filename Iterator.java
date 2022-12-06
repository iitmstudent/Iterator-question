import java.util.*;
interface Printable{
  void print();
  
}
interface Iterable {
  boolean has_next();
  Printable get_next();
}
class ComplexNum implements Printable{
  int i,r;
  public ComplexNum(int i,int r){
    this.r=r;
    this.i=i;
  }
  public void print(){
    System.out.println(this.r+" + "+this.i+"i");
  }
}
class ComplexList {
  ComplexNum [] list;
  public ComplexList(ComplexNum [] list){
    this.list=list;
  }
  public Iterable getIterable(){
    ComplexIterator a2 = new ComplexIterator();
    return a2;
  }
  private class ComplexIterator implements Iterable{
    int indx;
    public ComplexIterator(){
      this.indx =-1;
    }
    public boolean has_next(){
     if (indx < list.length-1){
       return true;
     }
      return false;
    }
    public Printable get_next(){
      indx++;
      return list[indx];
    }
  }
}
class Main{
  public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    ComplexNum [] arr = new ComplexNum[n];
    for(int i =0;i<arr.length;i++){
      int n1 = s.nextInt();
      int n2 = s.nextInt();
      ComplexNum c1 = new ComplexNum(n1,n2);
      arr[i] = c1;
    }
    ComplexList a = new ComplexList(arr);
    Iterable it = a.getIterable();
    while(it.has_next()){
       it.get_next().print();
    }
  }
}
