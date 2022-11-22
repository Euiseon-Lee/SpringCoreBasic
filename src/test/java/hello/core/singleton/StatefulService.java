package hello.core.singleton;

public class StatefulService {
//    private int price;  //상태를 유지하는 필드 -> 사용X

//    public void order(String name, int price){
    public int order(String name, int price){
        System.out.println("name = " + name + " price = "+price);

        //싱글톤 패턴 사용 시 주의할 점
        //여기서 StatefulService의 price 필드는 공유되는 필드
        //this로 지칭하게 되면 다른 클라이언트가 값을 바꿀 수 있게 된다
        //this.price = price;

        //해결책
        return price;
    }
 //   public int getPrice(){
 //       return price;
 //   }
}
