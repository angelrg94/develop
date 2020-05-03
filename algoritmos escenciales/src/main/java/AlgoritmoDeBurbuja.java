import java.lang.reflect.Array;
import java.util.Random;

public class AlgoritmoDeBurbuja {


    public static void main(String[] args){
    int arreglo[] = new int[20];
    Random random = new Random();
     for(int i = 0; i < arreglo.length - 1; i++){
         arreglo[i]= random.nextInt();
     }

        System.out.print("Desordenado"+"\n");
        for(int i = 0; i < arreglo.length - 1; i++){
            System.out.print(arreglo[i]+"\n");

        }
        burbuja(arreglo);

    }


    static void burbuja(int arreglo[])
    {
        for(int i = 0; i < arreglo.length - 1; i++)
        {

            for(int j = 0; j < arreglo.length - 1; j++)
            {

                if (arreglo[j] > arreglo[j + 1])
                {
                    int tmp = arreglo[j+1];
                    arreglo[j+1] = arreglo[j];
                    arreglo[j] = tmp;
                }
            }
        }
        System.out.print("Ordenado"+"\n");
        for(int i = 0;i < arreglo.length; i++)
        {
            System.out.print(arreglo[i]+"\n");
        }
    }


}
