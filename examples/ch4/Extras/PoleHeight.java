import java.text.*;
import java.util.*;
class Ch3PoleHeight {
    public static void main( String[] args ) {
        double height;
        double distance;
        double alpha;
        double beta;
        double alphaRad;
        double betaRad;
        final String NEWLINE = "\n";
        //height of the pole
        //distance between points A and B
        //angle measured at point A
        //angle measured at point B
        //angle alpha in radians
        //angle beta in radians
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(System.getProperty("line.separator"));
        
        //Get three input values
        System.out.print("Angle alpha (in degrees):");
        alpha = scanner.nextDouble();
        System.out.print("Angle beta (in degree):");
        beta = scanner.nextDouble();
        System.out.print("Distance between points A and B (ft):");
        distance = scanner.nextDouble();
        
        //compute the height of the tower
        alphaRad = Math.toRadians(alpha);
        betaRad = Math.toRadians(beta);
        height = ( distance * Math.sin(alphaRad) * Math.sin(betaRad)) / Math.sqrt( Math.sin(alphaRad + betaRad) * Math.sin(alphaRad - betaRad) );
        DecimalFormat df = new DecimalFormat("0.000");
        System.out.println("lnln Estimating the height of the pole" + NEWLINE + NEWLINE + "Angle at point A (deg):" + df.format(alpha) + NEWLINE + "Angle at point B (deg): " + df.format(beta) + NEWLINE + "Distance between A and B (ft): " + df.format(distance)+ NEWLINE + "Estimated height (ft): " + df.format(height));
        scanner.close();
    }
}
