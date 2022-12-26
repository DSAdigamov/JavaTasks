class SecantMethod implements Solver{

    @Override
    public void solve(double a, double b, double accuracy) {
        double xm, x0, c;
        int count = 0;

        if (Function.calculate(a) * Function.calculate(b) < 0) {
            do {

                // intermediate

                x0 = (a * Function.calculate(b) - b * Function.calculate(a))
                        / (Function.calculate(b) - Function.calculate(a));

                // check if x0 is root of
                c = Function.calculate(a) * Function.calculate(x0);

                // update the value of interval
                a = b;
                b = x0;

                // update number of iteration
                count++;

                // if x0 is the root of equation
                // then break the loop
                if (c == 0)
                    break;
                xm = (a * Function.calculate(b) - b * Function.calculate(a))
                        / (Function.calculate(b) - Function.calculate(a));

                // repeat the loop until the convergence
            } while (Math.abs(xm - x0) >= accuracy);

            System.out.println("Ответ: " + x0 + "\n" +
                    "Кол-во итераций: " + count);
        } else
            System.out.print("В этом интервале нет !");
    }
}