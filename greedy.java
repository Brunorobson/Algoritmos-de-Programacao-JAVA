import java.util.*;

class Activity implements Comparable<Activity> {
    int start, finish;

    public Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }

    public int compareTo(Activity other) {
        return this.finish - other.finish;
    }
}

public class greedy {
    public static void printMaxActivities(Activity[] activities) {
        Arrays.sort(activities);
        int n = activities.length;
        int selected = 1;
        int lastSelected = 0;

        for (int i = 1; i < n; i++) {
            if (activities[i].start >= activities[lastSelected].finish) {
                selected++;
                lastSelected = i;
            }
        }

        System.out.println("Maximum number of non-overlapping activities: " + selected);
    }

    public static void main(String[] args) {
        Activity[] activities = {
            new Activity(1, 4), new Activity(3, 5),
            new Activity(0, 6), new Activity(5, 7),
            new Activity(3, 9), new Activity(5, 9),
            new Activity(6, 10), new Activity(8, 11),
            new Activity(8, 12), new Activity(2, 14),
            new Activity(12, 16)
        };

        printMaxActivities(activities);
    }
}
