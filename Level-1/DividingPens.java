public class DividingPens{
    public static void main(String[] args) {
        int totalPens=14, totalStudents=3,penPerStudents,notDistributed;
       
	notDistributed=totalPens%totalStudents;
        penPerStudents=totalPens/totalStudents;

        
        System.out.println(" The Pen Per Student is "+penPerStudents+"  and the remaining pen not distributed is "+notDistributed );



    }
}
