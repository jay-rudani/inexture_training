package Constructor;

class CopyConstructor {

    String title;
    String author;

    CopyConstructor(String title, String author) {
        this.title = title;
        this.author = author;
    }

    CopyConstructor(CopyConstructor book) {
        this.title = book.title;
        this.author = book.author;
    }

    public static void main(String[] args) {

        CopyConstructor orgBook = new CopyConstructor("A Game of Thrones", "George R.R. Martin");
        CopyConstructor copyBook = new CopyConstructor(orgBook);
        System.out.println("Copy book title : " + copyBook.title + "\nCopy book author : " + copyBook.author);
    }

}
