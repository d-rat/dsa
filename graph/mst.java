package graph;

import graph.dsu;
import java.util.*;

public class mst {
    public static void main(String[] args) {
        // https://leetcode.com/problems/min-cost-to-connect-all-points/description/
        int[][] points = new int[][] { { 3276, -9872 }, { -5462, 7348 }, { 6312, 8011 }, { -5791, 2539 },
                { 1638, -3454 },
                { -7139, 4115 }, { 8288, -5401 }, { -6867, 1357 }, { -5349, -3953 }, { -3543, -1768 }, { 9311, -4551 },
                { 3186, 4960 }, { 5078, -6374 }, { 2213, 7315 }, { -8553, -1168 }, { -5908, 4714 }, { -8502, 1952 },
                { 3907, -6858 }, { 3480, 2163 }, { 667, -8949 }, { -2518, 7807 }, { -8560, -1598 }, { -8422, 7136 },
                { 7393, -392 }, { -4848, -115 }, { 7486, 4117 }, { 9957, 4211 }, { -3121, 8673 }, { -3150, 5395 },
                { 4660, 1087 }, { 7137, -8867 }, { -6136, -7879 }, { -6301, -6641 }, { -5628, 1076 }, { 4910, 3879 },
                { -9664, -3533 }, { -7316, 1076 }, { -1713, 5620 }, { -4995, 3076 }, { -6995, -4534 }, { 252, -5061 },
                { 6978, -6247 }, { -2359, -1802 }, { -9000, -8227 }, { -6019, -9549 }, { -579, -4188 }, { -6919, 2767 },
                { 1985, 7880 }, { 7510, -5560 }, { -6068, 8463 }, { 109, -287 }, { -6281, 5828 }, { 3277, 3860 },
                { 3791, -9925 }, { 1856, -2341 }, { 2821, -6622 }, { -7098, 9476 }, { 3018, 4965 }, { -389, -5408 },
                { 6544, 9270 }, { 4458, -306 }, { -4119, -8806 }, { 713, 1866 }, { -380, 8271 }, { 8162, 5764 },
                { 2902, -2843 }, { -6945, 8946 }, { 844, -3650 }, { -2435, -7813 }, { 3886, -3449 }, { -8323, -2934 },
                { -1361, 8919 }, { 1950, -4881 }, { -5138, -8717 }, { -3361, 6082 }, { -5404, -4263 }, { 7184, 7475 },
                { -2319, 3174 }, { -5592, 7868 }, { -6122, -1715 }, { -211, -1436 }, { 1053, -7579 }, { -4159, -3171 },
                { 7450, 42 }, { -2810, -2498 }, { -8370, -5819 }, { -3831, -8881 }, { 1911, -4231 }, { -1838, 9379 },
                { -9946, 7576 }, { 5952, 7480 }, { 7401, -717 }, { 2162, -3108 }, { 7276, -5900 }, { -1340, 4153 },
                { -2289, -8876 }, { -6463, -4097 }, { 6877, 9377 }, { -4273, 84 }, { -5, 2030 }, { -907, -7297 },
                { -7764, 3240 }, { 2240, 3831 }, { 4928, -3093 }, { 5981, -9227 }, { -4291, 8008 }, { -5811, -6709 },
                { 4465, 9850 }, { -9328, -5702 }, { -5095, -2398 }, { -8658, -1082 }, { 4958, -2005 }, { 3653, 2387 },
                { -3204, -744 }, { 1399, -9488 }, { -505, -2478 }, { 5100, -8158 }, { 1350, 5202 }, { 3034, -4393 },
                { 6469, 9777 }, { 9834, 4041 }, { 2042, -3263 }, { 8582, -9389 }, { 4008, 2806 }, { -2145, 4394 },
                { 1647, -8628 }, { -4825, -3048 }, { -281, -57 }, { -5656, -3361 }, { 9040, -708 }, { 7887, -3032 },
                { -8691, 891 }, { 818, -8082 }, { -42, -4407 }, { 8477, 4861 }, { -8503, 8737 }, { -6892, 8707 },
                { -8347, -6856 }, { 9465, -4991 }, { 8251, 2605 }, { -3842, 6376 }, { -1230, 1873 }, { -5801, 3867 },
                { 1941, 1918 }, { -1965, 8208 }, { 5116, -1106 }, { 2352, 9891 }, { 7957, -9430 }, { -246, 2663 },
                { -5508, 850 }, { -5111, -9438 }, { 5599, -367 }, { 5905, 2833 }, { 8424, -1120 }, { -1930, -5075 },
                { -9930, 5053 }, { 9643, 2897 }, { -9824, 3119 }, { 9694, -5805 }, { 7424, -5691 }, { 7467, 7403 },
                { -4838, -5454 }, { 204, 8395 }, { 505, 1835 }, { 6567, -7020 }, { 7524, -7187 }, { -8577, -8839 },
                { 6106, -6848 }, { 7743, -9043 }, { 6686, -2341 }, { -6685, -2022 }, { -454, -9349 }, { 1106, 4077 },
                { -7474, -9901 }, { -5473, 1623 }, { -1872, 9088 }, { 9848, -4992 }, { 1976, -3069 }, { 2465, -7018 },
                { -5055, -159 }, { -1475, 8269 }, { -1232, 8477 }, { -3825, -4056 }, { -4397, 4492 }, { -3265, 4423 },
                { 6454, 5430 }, { 9993, 4436 }, { 9171, 3952 }, { 2779, 5683 }, { -1282, 3884 }, { -8786, 9426 },
                { 5739, -8490 }, { -9693, 9203 }, { -5421, 2636 }, { 6511, -6438 }, { -8166, 3675 }, { -2010, 1703 },
                { 5663, 9146 }, { -5416, 1011 }, { 8737, -3444 }, { -3686, 4270 }, { -1447, 6931 }, { -8481, 881 },
                { 2828, -7198 }, { -6350, 724 }, { 2914, -6097 }, { 3514, 7797 }, { 3974, 8994 }, { 56, 3041 },
                { 3589, 4307 }, { 2065, 5942 }, { -8719, -1581 }, { 8207, -722 }, { -2961, -8652 }, { 2695, -7763 },
                { -5831, 8797 }, { 3229, 1657 }, { -333, -8419 }, { -5438, -9843 }, { -6695, 1360 }, { 7395, 3085 },
                { 3323, 7416 }, { 4833, -3078 }, { -5298, 828 }, { 3537, 1051 }, { -7104, -6464 }, { -5173, -6952 },
                { -8892, 346 }, { -517, -4810 }, { 8786, -7611 }, { -9233, 8339 }, { -3500, 121 }, { -7204, -5023 },
                { -6847, -2499 }, { -9528, 2819 }, { 3324, -3707 }, { -9129, -92 }, { -4546, -531 }, { 9811, -6079 },
                { -2121, 1927 }, { -3251, -209 }, { -8634, 7427 }, { 1546, 1832 }, { -8787, -3281 }, { -3519, -6697 },
                { 2529, 903 }, { -2735, 3864 }, { 7766, 2303 }, { 1064, 9070 }, { 3079, 36 }, { -8977, 603 },
                { 108, -7245 }, { 854, 5887 }, { 6787, 7712 }, { -3936, -4766 }, { -5381, -5254 }, { -263, 5115 },
                { -31, 7412 }, { -8973, -9616 }, { -9417, -3116 }, { -3929, -4013 }, { 8828, 2591 }, { 7422, -4863 },
                { 187, -2589 }, { 4490, 7237 }, { -4967, -846 }, { -3149, -4879 }, { -5023, 1619 }, { 3771, -4938 },
                { -8526, 8477 }, { -4334, 8876 }, { 449, -2661 }, { -3890, 5728 }, { 8239, -1392 }, { 6350, 957 },
                { -6515, -2168 }, { -5596, 9723 }, { -1653, 7147 }, { -4651, -3634 }, { -2503, 9428 }, { 463, -2309 },
                { 31, -6436 }, { 5398, 4863 }, { 4786, 6975 }, { 3093, 4724 }, { 7895, 7977 }, { 3831, 2234 },
                { -1453, 100 }, { 5377, -8398 }, { 1280, -6947 }, { -1669, -1095 }, { 2162, 412 }, { -6906, 6879 },
                { -5637, -7380 }, { 1113, -8573 }, { -5536, 7781 }, { 7970, -353 }, { 9403, 3215 }, { 1726, -7100 },
                { -1331, 9758 }, { 5846, 8900 }, { 255, -2513 }, { 2455, 4136 }, { 4761, 1229 }, { 5320, -7273 },
                { -7836, -3408 }, { -8083, -664 }, { 7867, 5411 }, { 8882, 7965 }, { -3605, -9845 }, { 5313, -9121 },
                { 1045, -3456 }, { -5260, -7639 }, { 6456, 2362 }, { -9201, 9781 }, { 7114, 8367 }, { 7605, -8544 },
                { -6178, -3567 }, { 6323, 9995 }, { 1964, -3137 }, { -3837, 5135 }, { 5053, 9675 }, { -924, -2332 },
                { -2223, -6060 }, { -7612, 3189 }, { 9903, 277 }, { 9820, 6201 }, { 3865, -155 }, { -806, -540 },
                { 6592, 8151 }, { -4060, 3804 }, { 4969, -7231 }, { 6151, -201 }, { 6754, 1620 }, { 50, -3988 },
                { 6793, 1825 }, { 2666, 156 }, { 5815, 8183 }, { 5607, 1455 }, { -6994, -1404 }, { -6811, -6570 },
                { 1989, -9490 }, { -5724, -2569 }, { 3777, -6434 }, { -3304, -9188 }, { -3279, 8989 }, { 2087, -4714 },
                { 8758, -8069 }, { -9083, -1567 }, { -1581, -654 }, { -7868, 9804 }, { 6873, -3662 }, { 545, -2038 },
                { 8297, 9534 }, { -3927, 2727 }, { 1496, 2984 }, { -8225, 1456 }, { -7604, 4696 }, { 6141, -2921 },
                { -8648, -6528 }, { -1482, -1384 }, { -1789, -9077 }, { 9976, 1721 }, { -1132, -5894 }, { 7463, -8363 },
                { 4760, 3051 }, { 6182, -1352 }, { 5777, -6277 }, { 2564, -419 }, { 3182, -3385 }, { -323, -3138 },
                { 9974, 7722 }, { -2441, -3485 }, { 1342, 8365 }, { 5646, -3286 }, { -5045, 2525 }, { -3468, -5595 },
                { -9926, 3158 }, { -6146, -8671 }, { 8582, -1567 }, { -6952, -3681 }, { -501, -1029 }, { -5589, -3507 },
                { -8047, 9406 }, { 6929, -7366 }, { 1265, -6074 }, { -5455, 456 }, { -8421, 1485 }, { 4966, 4309 },
                { 40, -5364 }, { -49, 3330 }, { -9548, 6835 }, { 7629, -4757 }, { 8379, 311 }, { -5923, -950 },
                { -593, -9056 }, { -2971, 3873 }, { -9408, -7909 }, { 2956, -3792 }, { -916, 9974 }, { -2998, -4020 },
                { -3373, -5111 }, { -893, 4450 }, { 4096, -2868 }, { -939, 4157 }, { -1173, 1853 }, { 1505, -84 },
                { -1333, 7032 }, { 9100, 6724 }, { 314, -9550 }, { -2470, 6557 }, { 5783, -5842 }, { -6605, 3868 },
                { 6990, 3080 }, { -1527, -8415 }, { 6157, -9035 }, { 1480, -7336 }, { 4840, -1907 }, { 865, 4433 },
                { 6583, -7028 }, { 9510, 8311 }, { 7030, 8472 }, { -8916, -1049 }, { 8816, 3556 }, { 7732, -1032 },
                { -4986, -385 }, { -750, 2356 }, { -5488, -2436 }, { 2005, -4980 }, { 2073, -4532 }, { -4230, -5859 },
                { 6023, 6082 }, { 4748, 1239 }, { 4429, 9451 }, { 1160, 5311 }, { -3333, 7647 }, { -6584, 7121 },
                { -7153, 2798 }, { 3078, 8518 }, { -5563, 7109 }, { 6368, 21 }, { 2128, -8012 }, { -1871, -4517 },
                { 2861, -4398 }, { -8222, -8472 }, { 2875, 141 }, { -1620, 7411 }, { -6065, 1108 }, { 1977, -1372 },
                { 7881, 173 }, { 3858, -3237 }, { -6629, -7098 }, { -9244, 4063 }, { -8113, -2385 }, { -5964, -3395 },
                { 9373, 6690 }, { -4993, 3754 }, { -3594, -8251 }, { -6952, 7297 }, { 2269, -6020 }, { 1612, -9479 },
                { 3321, 6145 }, { 4019, -5826 }, { 5404, -3955 }, { 5794, 9335 }, { 4124, 642 }, { -2771, 9237 },
                { -3360, -4591 }, { 1591, 3745 }, { 481, 6823 }, { 3023, 7121 }, { 7704, -1698 }, { 481, 2609 },
                { -7675, 891 }, { 1300, 1283 }, { 2947, -9795 }, { 1678, -8759 }, { -5295, -1778 }, { -492, -8803 },
                { -4677, 5245 }, { -7746, -8515 }, { 9682, -890 }, { 8630, -3963 }, { -4970, -1540 }, { 3006, 8277 },
                { -8265, -9762 }, { -3968, 4723 }, { -1793, 7466 }, { -860, 9080 }, { -1527, -3014 } };

        mstByKruskal(points);
        mstByPrims(points);
    }

    static void mstByKruskal(int[][] points) {
        // greedy algo
        // take edge with minimum weight epeatedly ubtil you get exactly n-1 edges.
        // skip those edges which results in cycle - use dsu to check cycle.
        int n = points.length;
        Edge[] graph = new Edge[n * (n - 1) / 2];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int w = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                graph[idx++] = new Edge(i, j, w);
            }
        }

        Arrays.sort(graph, (a, b) -> a.w - b.w);
        Set<Edge> mst = new HashSet<>();
        dsu set = new dsu(n);

        for (Edge e : graph) {
            if (set.isConnected(e.u, e.v))
                continue;
            set.union(e.u, e.v);
            mst.add(e);
        }

        System.out.println("mst == " + mst.size());

    }

    static class Edge {
        int u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    static void mstByPrims(int[][] points) {
        // greedy algo
        // take a empty set and start with any random node add all this vertes's edges
        // to set(proiority queue for optimisation)
        // take an lowest cost edge from the set and add it to mst also add newly
        // connected vertex to seen set.
        // skip those edges in which both vertices are in the mst or out of mst at
        // present.
        // repeat process until you have covered all edges.

        int n = points.length;
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.w - b.w);

        for (int j = 1; j < n; j++) {
            int w = Math.abs(points[0][0] - points[j][0]) + Math.abs(points[0][1] - points[j][1]);
            pq.add(new Edge(0, j, w));
        }

        Set<Integer> seen = new HashSet<>();
        Set<Edge> mst = new HashSet<>();
        seen.add(0);

        while (seen.size() != n) {
            Edge e = pq.poll();
            if (seen.contains(e.u) == seen.contains(e.v))
                continue;
            mst.add(e);
            int v;
            if (seen.add(e.u))
                v = e.u;
            else {
                seen.add(e.v);
                v = e.v;
            }

            for (int i = 0; i < n; i++) {
                int w = Math.abs(points[v][0] - points[i][0]) + Math.abs(points[v][1] - points[i][1]);
                if (seen.contains(v) == seen.contains(i))
                    continue;
                pq.add(new Edge(v, i, w));
            }

        }

        System.out.println("mst == " + mst.size());

    }

}
