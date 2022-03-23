# Átlag signum szorzás

## Bevezetés

Ebben a feladatban egy metódust kell létrehoznod, ami egy tömböt dolgoz fel.

A `main` metódusban próbálhatod ki a kódodat, illetve használd az előre megírt teszteseteket az algoritmusod
kipróbálására!
A kiadott teszt eseteken ne módosíts!

## Feladatleírás

Írj egy metódust a `hu.nive.ujratervezes.multavgsignum.Calculation` osztályban a következő specifikácó alapján:

- a metódus neve: `multBySignum`
- a metódus bemeneti paraméterei:
    - `numbers`, egy egész számokat tartalmazó tömb `int[]`
    - `n`, egy egész szám `int`
- visszatérési értéke:
    - egy új, egész számokat tartalmazó tömb `int[]`

Az `multBySignum` metódus:
Megkeresi az átlag értéket a `numbers` tömbben, (az átlag legyen egész, eredménye az egész osztásnak!). Visszaad egy
tömböt amire a következő igaz:

- minden `n`-edik elem a `numbers` tömb azonos indexén található `a` elem és az átlag `a` elemből kivont `signum`
  függvényének **szorzata**. (Tehát, ha az n-edik számok kisebbek, mint az átlag, -1-gyel kell megszorozni, ha a szám pont az átlaggal egyenlő, 0-val kell megszorozni, ha az átlagnál nagyobb, 1-gyel kell megszorozni, vagyis nem változik)
- a többi elem a `numbers` tömb azonos indexén található elemel egyezik.

A signum függvény definiciója `sgn(x)=`:

- `0` ha x = 0
- `1` ha 0 < x
- `-1` ha x <0

A beépített `sort()`,`min()`, `max()`, `average()`, stb... metódusok használata a feladat megoldása során nem
megengedett.

Kivételkezelés:

- ha a metódust úgy hívjuk meg, hogy a `numbers` paraméter egy üres tömb, akkor adjon vissza egy új, üres tömböt
- ha a metódust úgy hívjuk meg, hogy a `numbers` paraméter értéke `null`, akkor dobjon `IllegalArgumentException`-t
- ha a metódust úgy hívjuk meg, hogy az `n` paraméter értéke kisebb, mint `1`, akkor dobjon `IllegalArgumentException`-t

## Példák

| `numbers`           | `Átlag` | `n`  | Eredmény                   |
|---------------------|:-------:|------|:---------------------------|
| `[-2, -1, 0, 1, 2]` |    0    | `2`  | `[-2, 1, 0, 1, 2]`         |
| `[3, 1, 5, 3, 4]`   |    3    | `1`  | `[0, -1, 5, 0, 4]`         |
| `[2, 12]`           |    7    | `1`  | `[-2, 12]`                 |
| `[]`                |    -    | `1`  | `[]`                       |
| `null`              |    -    | `1`  | `IllegalArgumentException` |
| `[2, 12]`           |    -    | `0`  | `IllegalArgumentException` |
| `[2, 12]`           |    -    | `-1` | `IllegalArgumentException` |

## Tesztek

```java
class CalculationTest {

  @Test
  void testCalculation_validInput() {
    Assertions.assertArrayEquals(new int[]{-2, 1, 0, 1, 2}, new Calculation().multBySignum(new int[]{-2, -1, 0, 1, 2}, 2));
  }

  @Test
  void testCalculation_validInput1() {
    Assertions.assertArrayEquals(new int[]{0, -1, 5, 0, 4}, new Calculation().multBySignum(new int[]{3, 1, 5, 3, 4}, 1));
  }

  @Test
  void testCalculation_validInput2() {
    Assertions.assertArrayEquals(new int[]{-2, 12}, new Calculation().multBySignum(new int[]{2, 12}, 1));
  }

  @Test
  void testCalculation_emptyArray() {
    Assertions.assertArrayEquals(new int[]{}, new Calculation().multBySignum(new int[]{}, 1));
  }

  @Test
  void testCalculation_throwsIllegalArgumentExceptionForNullParameter() {
    Calculation calculation = new Calculation();
    Assertions.assertThrows(IllegalArgumentException.class, () -> calculation.multBySignum(null, 1));
  }

  @Test
  void testCalculation_throwsIllegalArgumentExceptionForZero() {
    Calculation calculation = new Calculation();
    Assertions.assertThrows(IllegalArgumentException.class, () -> calculation.multBySignum(new int[]{2, 12}, 0));
  }

  @Test
  void testCalculation_throwsIllegalArgumentExceptionForNegative() {
    Calculation calculation = new Calculation();
    Assertions.assertThrows(IllegalArgumentException.class, () -> calculation.multBySignum(new int[]{2, 12}, -1));
  }
}
```

## Pontozás

Egy feladatra 0 pontot ér, ha:

- nem fordul le
- lefordul, de egy teszteset sem fut le sikeresen.
- ha a forráskód olvashatatlan, nem felel meg a konvencióknak, nem követi a clean code alapelveket.

0 pont adandó továbbá, ha:

- kielégíti a teszteseteket, de a szöveges követelményeknek nem felel meg

Pontokat a további működési funkciók megfelelősségének arányában kell adni a vizsgafeladatra:

- 5 pont: az adott projekt lefordul, néhány teszteset sikeresen lefut, és ezek funkcionálisan is helyesek. Azonban több
  teszteset nem fut le, és a kód is olvashatatlan.
- 10 pont: a projekt lefordul, a tesztesetek legtöbbje lefut, ezek funkcionálisan is helyesek, és a clean code elvek
  nagyrészt betartásra kerültek.
- 20 pont: ha a projekt lefordul, a tesztesetek lefutnak, funkcionálisan helyesek, és csak apróbb funkcionális vagy
  clean code hibák szerepelnek a megoldásban.

Gyakorlati pontozás a project feladatokhoz:

- Alap pontszám egy feladatra(max 20): lefutó egység tesztek száma / összes egység tesztek száma * 20, feltéve, hogy a
  megoldás a szövegben megfogalmazott feladatot valósítja meg
- Clean kód, programozási elvek, bevett gyakorlat, kód formázás megsértéséért - pontlevonás jár. Szintén
  pontlevonás jár, ha valaki a feladatot nem a leghatékonyabb módszerrel oldja meg - amennyiben ez értelmezhető.
