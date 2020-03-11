import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Polinom {
    ArrayList<Monom> a = new ArrayList<Monom>();

    public Polinom(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        String l = sc.nextLine();
        String[] t = l.split(" ");
        for (int j = 0; j < t.length; j = j + 2) {
            Monom m = new Monom();
            m.coef = Integer.parseInt(t[j]);
            m.deg = Integer.parseInt(t[j + 1]);
            a.add(m);
        }
    }

    public String toString() {
        String d = "";
        for (int i = 0; i < a.size() - 1; i++) {
            d += a.get(i) + "+";
        }
        return "" + d + a.get(a.size() - 1);
    }

    public void insert(int coef, int deg) {
        Monom k = new Monom(coef, deg);
        for (int i = 0; i <= a.size(); i++) {
            Monom d = new Monom();
            if (i == a.size()) {
                a.add(i, k);
                break;
            } else {
                d = (Monom) a.get(i);
                if (d.deg >= deg) {
                    a.add(i, k);
                    break;
                }
            }
        }
    }

    public void combine() {
        int t = a.size();
        Monom d = new Monom();
        Monom v = new Monom();
        for (int i = 0; i < t - 1; i++) {
            d = (Monom) a.get(i);
            for (int j = i + 1; j < t; j++) {
                v = (Monom) a.get(j);
                if (d.deg == v.deg) {
                    d.coef += v.coef;
                    a.remove(j);
                    t--;
                    j--;
                }
            }
        }
    }

    public void delete(int deg) {
        for (int i = 0; i < a.size(); i++) {
            Monom d = new Monom();
            d = (Monom) a.get(i);
            if (d.deg == deg) {
                a.remove(i);
                break;
            }
        }
    }

    public void sum(Polinom p) {
        for (int i = 0; i < p.a.size(); i++) {
            a.add(p.a.get(i));
        }
        combine();
    }

    public void derivate() {
        Monom d = new Monom();
        for (int i = 0; i < a.size(); i++) {
            d = (Monom) a.get(i);
            if (d.deg == 0) {
                a.remove(i);
                i--;
            }
            d.coef *= d.deg;
            d.deg--;
        }
    }

    public int value(int x) {
        int result = 0;
        Monom d = new Monom();
        for (int i = 0; i < a.size(); i++) {
            d = (Monom) a.get(i);
            result += d.coef * Math.pow(x,d.deg);
        }
        return result;
    }



    public void deleteOdd()  {
        int t = a.size();
        for (int i = 0; i < t; i++) {
            Monom d = new Monom();
            d = (Monom) a.get(i);
            if ((d.coef % 2) != 0) {
                a.remove(i);
                i--;
                t--;
            }
            if (a.size() == 0){
                throw new ArrayIndexOutOfBoundsException("no elements in List");
            }
        }
        }



    public static void main(String[] args) throws FileNotFoundException {
        Polinom g = new Polinom("file.txt");
        Polinom p = new Polinom("file1.txt");
        System.out.println("Полином : "+g.toString());
        g.insert(7,5);
        System.out.println("Вставка монома : "+g);
        g.combine();
        System.out.println("Приведение подобных членов : "+g);
        g.delete(5);
        System.out.println("Удаление элемента по степени : "+g);
        g.sum(p);
        System.out.println("Сумма с полиномом "+p.toString()+" = "+g);
        g.derivate();
        System.out.println("Производная полинома : "+g);
        System.out.println("Значение полинома в точке : "+g.value(1));
        g.deleteOdd();
        System.out.println("Удаление мономов с нечетными коэффициентами : "+g);
    }
}






















