public class ArrayList<T>  {
    Object[] arr = new Object[0];


    public int size() {
        return arr.length;
    }


    public Object[] toArray() {
        return arr;
    }


    public Object[] toArray(Object[] a) {
        return a;
    }


    public boolean add(Object a) {
        Object[] arrNew = new Object[arr.length + 1];
        for (int j = 0; j <arr.length ; j++) {
            arrNew[j] = arr[j];
        }
        arrNew[arrNew.length - 1] = a;
        arr = arrNew;
        return true;
    }

    public String toString() {
        String out = "[";
        for (Object c : arr) {
            out += " " + c;
        }
        return out + " ]";
    }

    public Object get(int index) {
        return arr[index];
    }


    public void add(int index, Object element) {
        Object[] arrNew = new Object[arr.length + 1];
        int i = 0;
        for (Object obj : arr) {
            if (i == index) {
                arrNew[i] = element;
                i++;
            }
                 arrNew[i] = obj;
                 i++;
                 if (i == arr.length){
                     arrNew[i] = element;
                 }
        }
        arr = arrNew;
    }


    public Object remove(int index) {
        int k = 0;
        Object[] arrNew = new Object[arr.length - 1];
        for (int j = 0; j < arr.length; j++) {
            if (j == index) {
                continue;
            }
            arrNew[k] = arr[j];
            k++;
        }
        arr = arrNew;
        return null;
    }
}
