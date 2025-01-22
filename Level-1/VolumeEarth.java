public class VolumeEarth{
    public static void main(String[] args) {
        int radiusKm=6378;
	    double radiusMiles=6378* 0.621371;
        double volumeKm,volumeMiles;
       	double pi=3.14;
	volumeKm=4/3*pi*radiusKm*radiusKm*radiusKm;
	volumeMiles=4/3*pi*radiusMiles*radiusMiles*radiusMiles;
        System.out.println("The Volume of Earth in cubic kilometers "+volumeKm+" and the volume of earth in cubic miles is "+volumeMiles);


    }
}
