package modules;

import java.util.ArrayList;

/**
 *
 * @author Nhom1
 */
public class XuLy {
    
    public static ArrayList<String> timTuXuatHienNhieuNhat(ArrayList<String> list){
        ArrayList<String> resultList = new ArrayList<>();
        ArrayList<String> primeList = new ArrayList<>();
        ArrayList<Integer> number = new ArrayList<>();
        do{
            String word = list.get(list.size()-1);
            primeList.add(word);
            list.remove(list.size()-1);
            int num = 1;
            while(list.indexOf(word)!=-1){
                int pos=list.indexOf(word);
                num++;
                list.remove(pos);
            }
            number.add(num);
        }while(!list.isEmpty());
        
        int max = number.get(0);
        for(int i:number){
            if(max<i){
                max=i;
            }
        }
        
        for(int i=0; i<number.size(); i++){
            if(max==number.get(i)){
                resultList.add(primeList.get(i)+": "+max);
            }
        }
        
        return resultList;
    }
    
}
