import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[] A) {
        return numberOfDiscIntersections(A);
    }

    private static final int MAXIMUM_NUMBER_OF_INTERSECTIONS = 10_000_000;

    private static class IntersectionPoint {

        private int disc;
        private int position;
        private boolean start;

        IntersectionPoint(int disc, int position, boolean start) {
            this.disc = disc;
            this.position = position;
            this.start = start;
        }
    }

    private int numberOfDiscIntersections(int[] radiuses) {
        int intersections = 0;

        IntersectionPoint[] intersectionPoints = new IntersectionPoint[2 * radiuses.length];
        for (int i = 0; i < radiuses.length; i++) {
            intersectionPoints[i] = new IntersectionPoint(i, i - radiuses[i], true);

            /* After radiuses.length - 1 disks can only end. So, instead of having a lot of end
             * coordinates with values that overflow Integer.MAX_VALUE (and, thus, making our
             * sort incorrect), we can map all of the disc end positions to radiuses.length
             * position. If we stored position as long, then sorting would become about too times
             * slower (and Codility would give a performance penalty). */
            int endPosition = i + Math.min(radiuses[i], radiuses.length);
            intersectionPoints[radiuses.length + i] = new IntersectionPoint(i, endPosition, false);
        }

        Arrays.sort(intersectionPoints, new Comparator<IntersectionPoint>() {
            @Override
            public int compare(IntersectionPoint o1, IntersectionPoint o2) {
                return Integer.compare(o1.position, o2.position);
            }
        });

        int openings = 0;
        int[] discStarts = new int[radiuses.length];
        for (IntersectionPoint point : intersectionPoints) {
            if (point.start) {
                discStarts[point.disc] = openings;
                openings++;
            } else {
                intersections += openings - discStarts[point.disc] - 1;
                if (intersections > MAXIMUM_NUMBER_OF_INTERSECTIONS) return -1;
            }
        }

        return intersections;
    }
}
