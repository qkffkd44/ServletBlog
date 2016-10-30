package Interface;

public class BoardPage {
  
  private int count;
  private int index;

  public BoardPage(){
    //default
    this.count = 3;
  }
  
  public BoardPage(int count, int list){
    this.count = count;
    this.index = list;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }
  
    
  

}
