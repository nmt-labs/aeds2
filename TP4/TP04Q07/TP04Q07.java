// Matrix
class Matrix {

    private Cell start;
    int height, width, size;

    //Constructor
    public Matrix() {
        this.start = new Cell();
        this.height = 0;
        this.width = 0;
        this.size = 0;
    }

    public Matrix(int w, int h) throws Exception {
        start = new Cell();
        width = 0;

        for (Cell aux = start; width < w; aux = aux.right, width++) {
            if (width < w - 1) {
                aux.right = new Cell();
                aux.right.left = aux;
            }
            height = 1;

            for (Cell i = aux; height < h; i = i.bottom, height++) {
                Cell temp = new Cell();
                i.bottom = temp;
                temp.top = i;

                if (i.left != null) {
                    temp.left = i.left.bottom;
                    i.left.bottom.right = temp;
                }
            }
        }
    }

    public boolean isEmpty() {
        return height == 0 && width == 0;
    }

    public Cell cellAt(int x, int y) throws Exception {
        if (isEmpty()) {
            throw new Exception("Matrix is Empty!");
        }

        if (x < 0 || y < 0 || x > width || y > height) {
            throw new Exception("The values must be in between 0 and height or width");
        }

        Cell aux = start;

        for (int counter = 0; counter < x; aux = aux.right, counter++) {
            ;
        }

        for (int index = 0; index < y; aux = aux.bottom, index++) {
            ;
        }
        return aux;
    }

    public int size() {
        return (width * height);
    }

    public boolean equalSize(Matrix matrix) {
        return height == matrix.height && width == matrix.width;
    }

    public void insert(int data) throws Exception {
        if (size == size()) {
            throw new Exception("The linked matrix is Full!");
        }

        cellAt(size % width, size / width).value = data;
        size++;
    }

    // Prints the anti diagonal of the matrix
    public void printAntiDiagonal() throws Exception {
        if (isEmpty()) {
            throw new Exception("The matrix is Empty!");
        }

        for (int counter = width - 1, index = 0; counter >= 0; counter--, index++) {
            MyIO.print(cellAt(counter, index).value + " ");
        }
        MyIO.println("");
    }

    // Prints the main diagonal of the matrix
    public void printMainDiagonal() throws Exception {
        if (isEmpty()) {
            throw new Exception("The matrix is Empty!");
        }

        for (int counter = 0, index = 0; counter < width; counter++, index++) {
            MyIO.print(cellAt(counter, index).value + " ");
        }
        MyIO.println("");
    }

    // Prints the entire matrix
    public void print() throws Exception {
        if (isEmpty()) {
            throw new Exception("The matrix is Empty!");
        }

        for (int counter = 0; counter < height; counter++) {
            for (int index = 0; index < width; index++) {
                MyIO.print(cellAt(index, counter).value + " ");
            }
            MyIO.println("");
        }
    }

    // add up the elements of the matrixes
    public Matrix sum(Matrix matrix) throws Exception {
        Matrix aux = new Matrix(width, height);

        if (isEmpty()) {
            throw new Exception("The matrix is Empty!");
        }

        if (!equalSize(matrix)) {
            throw new Exception("The matrixes must have the same size!");
        }

        for (int counter = 0; counter < height; counter++) {
            for (int index = 0; index < width; index++) {
                aux.insert(matrix.cellAt(index, counter).value + cellAt(index, counter).value);
            }
        }
        return aux;
    }

    // multiply the elements of the matrixes
    public Matrix mult(Matrix matrix) throws Exception {
        Matrix aux = new Matrix(width, height);

        if (isEmpty()) {
            throw new Exception("The matrix is Empty!");
        }

        if (!equalSize(matrix)) {
            throw new Exception("The matrixes must have the same size!");
        }

        Cell c1 = start;
        for (int h = 0; h < width; c1 = c1.bottom, h++) {
            Cell c2 = matrix.start;
            for (int i = 0; i < height; c2 = c2.right, i++) {
                int temp = 0;
                for (int j = 0; j < width; j++) {
                    temp += c1.value * c2.value;

                    if (j < width - 1) {
                        c1 = c1.right;
                        c2 = c2.bottom;
                    }
                }

                for (int auxC = 1; auxC < height; c1 = c1.left, c2 = c2.top, auxC++) {
                    ;
                }
                aux.insert(temp);
            }
        }
        return aux;
    }
}

// Cell Class
class Cell {

    int value;
    Cell top, bottom, left, right;

    //Constructor 
    public Cell() {
        this.value = 0;
        this.top = null;
        this.bottom = null;
        this.left = null;
        this.right = null;
    }

    public Cell(int value) {
        this.value = value;
        this.top = null;
        this.bottom = null;
        this.left = null;
        this.right = null;
    }
}

class TP04Q07 {
    public static void main(String[] args) throws Exception {
        System.setProperty("file.encoding", "UTF-8");
        MyIO.setCharset("UTF-8");
        int counter = MyIO.readInt();

        for (int i = 0; i < counter; i++) {
            Matrix matrix = new Matrix(MyIO.readInt(), MyIO.readInt());

            for (int j = 0; j < matrix.size(); j++) {
                matrix.insert(MyIO.readInt());
            }

            Matrix sMatrix = new Matrix(MyIO.readInt(), MyIO.readInt());
            for (int k = 0; k < sMatrix.size(); k++) {
                sMatrix.insert(MyIO.readInt());
            }

            matrix.printMainDiagonal();
            matrix.printAntiDiagonal();
            matrix.sum(sMatrix).print();
            matrix.mult(sMatrix).print();
        }
    }
}
