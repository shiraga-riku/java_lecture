import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.UIDefaults.ProxyLazyValue;

public class ThreeInRow
{
    private static List<Cell> cells = List.of(Cell.empty(), Cell.empty(), Cell.empty(),
        Cell.empty(), Cell.empty(), Cell.empty(), Cell.empty(), Cell.empty(), Cell.empty());

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("３目並べにようこそ");
        System.out.print("先手・後手を選んでください。先手(1),後手(2):");
        String firstSecond = sc.nextLine();

        Player humamPlayer = new HumanPlayer(sc,
            firstSecond.equals("1") ? CellStatus.BATSU : CellStatus.MARU);
        Player computerPlayer = new ComputerPlayer(
            firstSecond.equals("2") ? CellStatus.BATSU : CellStatus.MARU);

        Player player = firstSecond.equals("1") ? humamPlayer : computerPlayer;

        while (true) {
            int cellPlace = player.doTurn(cells);

            place(cellPlace,
                player.maruBatsu() == CellStatus.BATSU ? CellStatus.BATSU : CellStatus.MARU);

            player = player == humamPlayer ? computerPlayer : humamPlayer;

            printBoard();
            System.out.println("");
            System.out.println("");

            CellStatus isEnd = isEnd();
            if (isEnd != CellStatus.NONE) {
                System.out.println(isEnd == CellStatus.BATSU ? "先手の勝ち!" : "後手の勝ち!");
                break;
            }

            if (!hasEmpty()) {
                System.out.println("引き分け!");
                break;
            }
        }
    }

    private static void printBoard() {
        for (int i = 0; i < cells.size(); i++) {
            if (i % 3 == 0) {
                System.out.println();
            }
            CellStatus s = cells.get(i)
                                .status();
            System.out.print(s.label());
        }
    }

    private static void place(int cellIndex, CellStatus cellStatus) {
        cells.get(cellIndex)
             .change(cellStatus);
    }

    //0,1,2
    //3,4,5
    //6,7,8
    private static CellStatus isEnd() {
        if (isLine(0, 1, 2)) {
            return cells.get(0)
                        .status();
        }
        if (isLine(3, 4, 5)) {
            return cells.get(0)
                        .status();
        }
        if (isLine(6, 7, 8)) {
            return cells.get(0)
                        .status();
        }

        if (isLine(2, 4, 6)) {
            return cells.get(0)
                        .status();
        }
        if (isLine(0, 4, 8)) {
            return cells.get(0)
                        .status();
        }
        return CellStatus.NONE;
    }

    private static boolean isLine(int one, int two, int three) {
        return cells.get(one)
                    .status() != CellStatus.NONE
            && cells.get(one)
                    .status() == cells.get(two)
                                      .status()
            && cells.get(two)
                    .status() == cells.get(three)
                                      .status();
    }

    private static boolean hasEmpty() {
        for (Cell cell : cells) {
            if (cell.status() == CellStatus.NONE) {
                return true;
            }
        }
        return false;
    }
}

interface Player
{
    public int doTurn(List<Cell> cells);

    public CellStatus maruBatsu();
}

class HumanPlayer implements Player
{
    final Scanner sc;
    final CellStatus status;

    public HumanPlayer(Scanner sc, CellStatus status) {
        this.sc = sc;
        this.status = status;
    }

    @Override
    public int doTurn(List<Cell> cells) {
        while (true) {
            try {
                System.out.print("次の手を入力してください(行 列):");
                String line = sc.nextLine();
                var places = line.split("\\s+");
                var place = Integer.parseInt(places[0]) * 3 + Integer.parseInt(places[1]);
                if (place >= 0 && place < 9 && cells.get(place)
                                                    .status() == CellStatus.NONE) {
                    return place;
                }
            }
            catch (Exception e) {

            }
        }
    }

    @Override
    public CellStatus maruBatsu() {
        return this.status;
    }
}

class ComputerPlayer implements Player
{
    final CellStatus status;

    public ComputerPlayer(CellStatus status) {
        this.status = status;
    }

    @Override
    public int doTurn(List<Cell> cells) {
        try {
            System.out.println("コンピュータの番です");
            Thread.sleep(1000);
            return nextPlace(cells);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CellStatus maruBatsu() {
        return this.status;
    }

    private static int nextPlace(List<Cell> cells) {
        for (int i = 0; i < cells.size(); i++) {
            if (cells.get(i)
                     .status() == CellStatus.NONE) {
                return i;
            }
        }
        return -1;
    }
}

enum CellStatus
{
    MARU,
    BATSU,
    NONE;

    public String label() {
        switch (this) {
            case MARU:
                return "○";
            case BATSU:
                return "×";
            case NONE:
                return "−";
        }
        return null;
    }
}

class Cell
{
    CellStatus status = CellStatus.NONE;

    public void change(CellStatus to) {
        this.status = to;
    }

    public CellStatus status() {
        return this.status;
    }

    public static Cell empty() {
        return new Cell();
    }
}

