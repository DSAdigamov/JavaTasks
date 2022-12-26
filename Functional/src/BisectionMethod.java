public class BisectionMethod implements Solver
{

    @Override
    public void solve(double a, double b, double accuracy) {
        boolean found = false;
        double m =(a+b)/2.0;
        int count = 0;
        while((b-a >= accuracy) && (!found))
        {
            m = (a+b)/2.0;
            if(Function.calculate(m) == 0) {
                found = true;
            }
            else {
                if(Function.calculate(m)*Function.calculate(a) > 0) {
                    a = m;
                }
                else {
                    b = m;
                }
                count++;
            }
        }

        System.out.println("Ответ: " + round(m,7) + "\n" +
                "Кол-во итераций: " + count);
    }

    private static double round(double value, int dPlaces)
    {
        double x = Math.pow(10, dPlaces);
        double y = value * x;
        return Math.round(y)/x;
    }
}
