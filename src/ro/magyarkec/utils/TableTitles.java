package ro.magyarkec.utils;

public class TableTitles {

	public static enum SZEMELY_TABLE {

		ID("Id.",30), LAST_NAME("Családnév", 100), FIRSTNAME("Keresznév", 100), BIRTH_DATE("Sületési dátum",100),
        AGE("Életkor",50), JOB("Foglalkozás",100), ADDRESS("Cím",100), PHONE_NR("Telefonszám",100), EMAIL("E-mail",100),
        FATHER("Apa",100), MOTHER("Anya",100);
        ;

		private String mTitle;
		private int mWidth;

		private SZEMELY_TABLE(String title, int width) {
			this.mTitle = title;
			this.mWidth = width;
		}

		public String getTitle() {
			return mTitle;
		}

		public int getWidth() {
			return mWidth;
		}

	}

}
