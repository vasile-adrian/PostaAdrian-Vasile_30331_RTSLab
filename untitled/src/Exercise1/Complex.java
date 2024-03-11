package Exercise1;

public class Complex {

    private int real=0, imag=0;

    public Complex(int real, int imag){
        this.real = real;
        this.imag = imag;
    }

    public int getReal() {
        return real;
    }

    public int getImag() {
        return imag;
    }

    public Complex add(Complex b){
        return new Complex(this.real + b.getReal(), this.imag + b.getImag());
    }

    public Complex sub(Complex b){
        return new Complex(this.real - b.getReal(), this.imag - b.getImag());
    }

    public Complex mul(Complex b){
        return new Complex(
                this.real * b.getReal() - this.imag * b.getImag(),
                this.real * b.getImag() + this.imag * b.getReal()
        );
    }

    @Override
    public String toString() {
        return "(" + real + "+" + imag + "i)";
    }
}
