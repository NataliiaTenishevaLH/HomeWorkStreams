import java.util.Optional;

public class Pair {
    private static CustomerList first;
    private static CustomerList last;
    private  CustomerList before;
    private  CustomerList after;
    private static int size;

    public Pair(String str) {

            CustomerList lastValue = last;

            CustomerList customerRecord = new CustomerList(++size, str);
            this.after = customerRecord;

            last = customerRecord;

        if (lastValue != null) {
            lastValue.next = customerRecord;
            lastValue.previous = CustomerList.get(size - 1);
            this.before = lastValue.previous;
         }else{
            first = customerRecord;
           }
        }

    public String toString(){
        StringBuilder name = new StringBuilder();

        Optional<CustomerList> optionalRecordBefore = Optional.ofNullable(before);
        if (optionalRecordBefore.isPresent()) {
            name.append("before: " + this.before.getValue());
        }


        Optional<CustomerList> optionalRecordAfter = Optional.ofNullable(after);
        if (optionalRecordAfter.isPresent()){
            if (optionalRecordBefore.isPresent()){
                name.append(" after: " + this.after.getValue());
            } else{
                name.append(" first element: " + this.after.getValue());
            }
        }

        return name.toString();
   }

private static class CustomerList {
    String value;
    int id;
    CustomerList next;
    CustomerList previous;

    CustomerList(int id, String value){
        this.id = id;
        this.value = value;
    }

    private static CustomerList get(int index) {

        for (CustomerList x = first; x != null; x = x.next) {
             if(x.id == index) {
               return x;
            }
        }

        return null;
    }

     String getValue(){
        return value;
    }
}
}
