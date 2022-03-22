public class ComplexNumber 
{
    double Real, Imaginary;
 
    public ComplexNumber(double re, double im) 
    {
        this.Real = re;
        this.Imaginary = im;
    }
 
    public double getReal() 
    {
        return Real; 
    }

    public double getImaginary() 
    {
        return Imaginary; 
    }
 
    public ComplexNumber negate() 
    {
        double real, imaginary;
        ComplexNumber a = this;
        
            real = a.Real * (-1);
            imaginary = a.Imaginary * (-1);
        
                return new ComplexNumber(real, imaginary);
    }
 
    public ComplexNumber add(ComplexNumber z) 
    {
        double real, imaginary;
        ComplexNumber a = this;
        
            real = a.Real + z.Real;
            imaginary = a.Imaginary + z.Imaginary;
        
                return new ComplexNumber(real, imaginary);
    }
 
    public ComplexNumber subtract(ComplexNumber z) 
    {
        double real, imaginary;
        ComplexNumber a = this;
        
            real = a.Real - z.Real;
            imaginary = a.Imaginary - z.Imaginary;
        
                return new ComplexNumber(real, imaginary);
        
    }

    public ComplexNumber multiply(ComplexNumber z) 
    {
        
        double real, imaginary;
        ComplexNumber a = this;
        
            real = (a.Real * z.Real) - (a.Imaginary * z.Imaginary);
            imaginary = (a.Real * z.Imaginary) + (a.Imaginary * z.Real);
        
                return new ComplexNumber(real, imaginary);
    }

    public ComplexNumber reciprocal() 
    {
        double real, imaginary, scale;
        ComplexNumber a = this;
        
            scale = (a.Real * a.Real) + (a.Imaginary * a.Imaginary);
            real = a.Real / scale;
            imaginary = a.Imaginary / scale;
        
                return new ComplexNumber(real, imaginary);        
    }

    public ComplexNumber divide(ComplexNumber z) 
    {
        ComplexNumber a = this;
            return a.multiply(z.reciprocal());
    }
 
    @Override
    public String toString() 
    {
        String str = "" + this.getReal();
        if (this.getImaginary() == 0.0) 
        {
            return str;
        }
        
        if (this.getImaginary() > 0) 
        {
            return str + " + i" + this.getImaginary();
        } 
        else 
        {
            return str + " - i" + -this.getImaginary();
        }
    }
 /**
 * The output should be:
 * <pre>
 * a = 1.0 + i2.0
 * b (-a) = -1.0 - i2.0
 * c = 2.0 + i3.0
 * d (a + c) = 3.0 + i5.0
 * e (a - c) = -1.0 - i1.0
 * f (1 / a) = 0.2 - i0.4
 * g (a / c) = 0.6153846153846154 + i0.07692307692307693
 * h (a * c) = -4.0 + i7.0
 * </pre>
 * @param args Command line args not used.
 */
    public static void main(String[] args) 
    {
        ComplexNumber a, b, c, d, e, f, g, h;
        a = new ComplexNumber(1, 2);
            System.out.println("a = " + a);
        b = a.negate();
            System.out.println("b (-a) = " + b);
        c = new ComplexNumber(2, 3);
            System.out.println("c = " + c);
        d = a.add(c);
            System.out.println("d (a + c) = " + d);
        e = a.subtract(c);
            System.out.println("e (a - c) = " + e);
        f = a.reciprocal();
            System.out.println("f (1 / a) = " + f);
        g = a.divide(c);
            System.out.println("g (a / c) = " + g);
        h = a.multiply(c);
            System.out.println("h (a * c) = " + h);
    }
}