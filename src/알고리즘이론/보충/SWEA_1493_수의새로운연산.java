package 알고리즘이론.보충;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    좌표 <==> 값 이차원 배열 탐색 --> 규칙찾ㄱ ㅣ
    대각선 x y value
 */
public class SWEA_1493_수의새로운연산 {

    static BufferedReader in;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int T, Answer;
    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(in.readLine());

        for(int tc = 1; tc <= T ; tc ++) {
            Answer = 0;
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[] coordA = getCoord(a);
            int[] coordB = getCoord(b);

            int[] newCoord = { coordA[0] + coordB[0], coordA[1] + coordB[1]};
            Answer = getValue(newCoord);
        }
    }

    private static int[] getCoord(int target) {
        int val = 1;
        for(int d = 1; ; d++) {
            for(int x = 1, y = d; x<=d; x++, y--) {
                if(target == val) {
                    //우리는 1차원 배열을 사용중이고 -> row , col )
                    return new int[] {y, x};
                }
                val ++;
            }
        }

    }
    private static int getValue(int[] coord) {
        int val = 1;
        for(int d = 1; ; d++) {
            for(int x = 1, y =d; x <= d; x++, y--) {
                //좌표와 일치하면 값 반환
                if(coord[0] == y && coord[1] == x) {
                    return val;
                }
            }
        }
    }





    static String src = "1000\n" +
            "6679 9828\n" +
            "4879 120\n" +
            "2478 7718\n" +
            "1383 3648\n" +
            "792 7548\n" +
            "2232 8523\n" +
            "6143 2656\n" +
            "3782 1436\n" +
            "9752 6385\n" +
            "9753 8573\n" +
            "7645 6337\n" +
            "4499 1257\n" +
            "7554 8022\n" +
            "1388 6922\n" +
            "7914 1147\n" +
            "5031 9019\n" +
            "7025 3078\n" +
            "765 4340\n" +
            "705 1857\n" +
            "1159 5123\n" +
            "9112 5395\n" +
            "926 2399\n" +
            "6886 1839\n" +
            "229 5453\n" +
            "3402 794\n" +
            "8939 8598\n" +
            "1028 4350\n" +
            "2676 1661\n" +
            "6642 7428\n" +
            "5487 6347\n" +
            "7085 596\n" +
            "3080 6452\n" +
            "6562 773\n" +
            "1693 9490\n" +
            "6060 8241\n" +
            "6218 8183\n" +
            "9631 1608\n" +
            "3335 893\n" +
            "8381 5938\n" +
            "6287 9536\n" +
            "6571 7375\n" +
            "6441 3664\n" +
            "1794 841\n" +
            "7721 6346\n" +
            "9648 7703\n" +
            "2966 5437\n" +
            "3655 8202\n" +
            "2716 7423\n" +
            "2731 617\n" +
            "5457 4736\n" +
            "838 7815\n" +
            "9745 2236\n" +
            "2037 905\n" +
            "2500 3884\n" +
            "9634 6379\n" +
            "621 8571\n" +
            "3427 9330\n" +
            "6011 3363\n" +
            "8503 8714\n" +
            "2778 9679\n" +
            "6686 6991\n" +
            "7520 5569\n" +
            "2824 1582\n" +
            "2259 7708\n" +
            "4586 2003\n" +
            "2000 6632\n" +
            "5719 3442\n" +
            "4771 2539\n" +
            "7331 8856\n" +
            "5308 868\n" +
            "3039 9273\n" +
            "8741 5528\n" +
            "1 1\n" +
            "6783 8672\n" +
            "4956 5023\n" +
            "1069 4879\n" +
            "1483 53\n" +
            "8766 1662\n" +
            "9176 4270\n" +
            "1413 9001\n" +
            "7337 5634\n" +
            "9882 5577\n" +
            "8767 6602\n" +
            "3712 1267\n" +
            "3967 9181\n" +
            "6799 9262\n" +
            "2907 2277\n" +
            "2009 7294\n" +
            "808 6400\n" +
            "4511 8949\n" +
            "3944 3674\n" +
            "2436 4007\n" +
            "3151 4032\n" +
            "6166 2788\n" +
            "8448 4116\n" +
            "9498 1616\n" +
            "1039 7670\n" +
            "47 7124\n" +
            "3662 623\n" +
            "6136 1676\n" +
            "6715 214\n" +
            "2629 1560\n" +
            "95 7965\n" +
            "1472 5374\n" +
            "1982 5995\n" +
            "7562 4172\n" +
            "3571 8186\n" +
            "8638 4817\n" +
            "6651 4224\n" +
            "5802 403\n" +
            "1455 6888\n" +
            "8987 5248\n" +
            "2901 815\n" +
            "9056 3439\n" +
            "701 4986\n" +
            "460 2942\n" +
            "8494 6909\n" +
            "6070 4644\n" +
            "3913 9531\n" +
            "2027 4886\n" +
            "5371 4155\n" +
            "456 469\n" +
            "325 4231\n" +
            "4283 6604\n" +
            "8094 9237\n" +
            "3673 5580\n" +
            "7165 7200\n" +
            "1967 8441\n" +
            "1745 9694\n" +
            "852 76\n" +
            "331 7786\n" +
            "4715 7322\n" +
            "1841 2833\n" +
            "8547 8777\n" +
            "3987 1550\n" +
            "1648 4800\n" +
            "4455 7928\n" +
            "9026 46\n" +
            "4079 7097\n" +
            "6827 6120\n" +
            "3208 136\n" +
            "3324 6773\n" +
            "7163 2590\n" +
            "4606 7123\n" +
            "3013 7778\n" +
            "9227 6434\n" +
            "4081 1503\n" +
            "1853 7222\n" +
            "5674 1706\n" +
            "8331 2608\n" +
            "1092 5215\n" +
            "2769 771\n" +
            "4403 4747\n" +
            "4327 1265\n" +
            "2088 1689\n" +
            "6415 6429\n" +
            "1337 9528\n" +
            "8521 7056\n" +
            "9415 8905\n" +
            "6761 2375\n" +
            "4760 9459\n" +
            "6893 5834\n" +
            "2397 8233\n" +
            "3138 3436\n" +
            "6531 4633\n" +
            "7078 7399\n" +
            "9620 8564\n" +
            "2133 8536\n" +
            "7461 427\n" +
            "191 2869\n" +
            "2688 1062\n" +
            "3270 9516\n" +
            "6209 941\n" +
            "9578 5885\n" +
            "3507 9913\n" +
            "9367 3124\n" +
            "4962 978\n" +
            "643 4906\n" +
            "5345 5457\n" +
            "4523 4604\n" +
            "1331 28\n" +
            "8829 9032\n" +
            "116 8327\n" +
            "8637 1213\n" +
            "4263 2864\n" +
            "4138 1450\n" +
            "7135 9352\n" +
            "1000 4212\n" +
            "5937 6287\n" +
            "2494 9330\n" +
            "638 5999\n" +
            "1280 1914\n" +
            "2676 1421\n" +
            "4188 4740\n" +
            "5836 7501\n" +
            "5039 5516\n" +
            "843 1997\n" +
            "5471 2771\n" +
            "4971 3543\n" +
            "560 1308\n" +
            "3057 4874\n" +
            "2537 3753\n" +
            "8302 6848\n" +
            "9598 8733\n" +
            "5480 7559\n" +
            "5582 3081\n" +
            "7393 7161\n" +
            "2668 2442\n" +
            "5341 1798\n" +
            "320 7967\n" +
            "934 2615\n" +
            "8102 5046\n" +
            "9522 6492\n" +
            "4812 4494\n" +
            "7961 7173\n" +
            "6261 172\n" +
            "7241 9890\n" +
            "2139 5368\n" +
            "9444 1220\n" +
            "1902 1679\n" +
            "2951 1436\n" +
            "8072 5209\n" +
            "6507 5785\n" +
            "2388 5019\n" +
            "9781 964\n" +
            "5752 9140\n" +
            "5320 8127\n" +
            "8280 8753\n" +
            "1367 5615\n" +
            "4740 1467\n" +
            "8478 8023\n" +
            "3791 1309\n" +
            "4065 8190\n" +
            "9080 9273\n" +
            "6897 2990\n" +
            "4674 1499\n" +
            "2844 6910\n" +
            "8814 4939\n" +
            "5563 2103\n" +
            "1142 1573\n" +
            "2204 4392\n" +
            "2506 1193\n" +
            "9288 2515\n" +
            "4222 1277\n" +
            "1301 552\n" +
            "7527 7337\n" +
            "299 6287\n" +
            "4275 7608\n" +
            "7160 9976\n" +
            "2344 5596\n" +
            "8685 1830\n" +
            "754 7792\n" +
            "4969 8125\n" +
            "2271 4341\n" +
            "3996 9265\n" +
            "2484 3416\n" +
            "3667 6240\n" +
            "5064 6144\n" +
            "2288 1645\n" +
            "494 8411\n" +
            "1625 638\n" +
            "9366 9368\n" +
            "6814 540\n" +
            "3227 1036\n" +
            "3542 8296\n" +
            "5068 5543\n" +
            "1145 4026\n" +
            "8132 7774\n" +
            "357 9378\n" +
            "60 5337\n" +
            "3923 4273\n" +
            "5886 2476\n" +
            "1377 3446\n" +
            "218 8696\n" +
            "4848 1460\n" +
            "515 1026\n" +
            "261 6825\n" +
            "6760 5672\n" +
            "6802 6207\n" +
            "4542 5249\n" +
            "5076 3812\n" +
            "2 8244\n" +
            "7300 6252\n" +
            "7418 2277\n" +
            "1816 2044\n" +
            "9107 3766\n" +
            "9778 1742\n" +
            "3434 9066\n" +
            "390 5170\n" +
            "8142 9098\n" +
            "9182 2825\n" +
            "5314 9914\n" +
            "4976 8217\n" +
            "6133 9282\n" +
            "2188 4863\n" +
            "732 1215\n" +
            "544 9342\n" +
            "8516 7906\n" +
            "4254 4259\n" +
            "9603 286\n" +
            "75 7883\n" +
            "5798 2852\n" +
            "7912 1208\n" +
            "4066 3881\n" +
            "8146 8114\n" +
            "7934 4052\n" +
            "5820 9218\n" +
            "5844 5483\n" +
            "3458 6999\n" +
            "9990 6845\n" +
            "445 3467\n" +
            "2693 9823\n" +
            "3580 7549\n" +
            "8362 2657\n" +
            "8495 8487\n" +
            "527 7864\n" +
            "5013 3575\n" +
            "60 2132\n" +
            "2293 1752\n" +
            "2869 4465\n" +
            "6006 5904\n" +
            "9001 6344\n" +
            "6441 9969\n" +
            "6370 9525\n" +
            "8475 3506\n" +
            "6522 9089\n" +
            "7270 4062\n" +
            "706 8808\n" +
            "8663 7249\n" +
            "6674 2474\n" +
            "7896 7456\n" +
            "6718 7763\n" +
            "2590 5345\n" +
            "1278 8829\n" +
            "5505 7677\n" +
            "9779 515\n" +
            "1873 5779\n" +
            "671 7141\n" +
            "7877 2325\n" +
            "843 5913\n" +
            "8948 6226\n" +
            "233 4199\n" +
            "670 9837\n" +
            "130 7290\n" +
            "962 2339\n" +
            "2438 947\n" +
            "9999 9998\n" +
            "1481 4280\n" +
            "918 5639\n" +
            "3914 1015\n" +
            "6749 7599\n" +
            "3653 4573\n" +
            "9339 4363\n" +
            "2120 1228\n" +
            "6273 2614\n" +
            "5296 2438\n" +
            "180 7960\n" +
            "5547 4133\n" +
            "5270 1138\n" +
            "3245 8773\n" +
            "8956 2402\n" +
            "9789 4822\n" +
            "1279 3155\n" +
            "7343 165\n" +
            "2957 7684\n" +
            "7282 1378\n" +
            "5608 4750\n" +
            "6426 5337\n" +
            "9844 4896\n" +
            "1445 1539\n" +
            "7459 1317\n" +
            "1143 1509\n" +
            "2323 7659\n" +
            "9736 3077\n" +
            "1380 8619\n" +
            "8947 2146\n" +
            "2045 9102\n" +
            "6479 8691\n" +
            "1622 8076\n" +
            "5144 484\n" +
            "6588 389\n" +
            "1381 2759\n" +
            "9818 6282\n" +
            "1186 3351\n" +
            "7445 4467\n" +
            "285 92\n" +
            "7349 9529\n" +
            "3954 4148\n" +
            "8913 2427\n" +
            "9457 7758\n" +
            "4394 8627\n" +
            "9749 7376\n" +
            "477 9487\n" +
            "7877 8296\n" +
            "1843 7891\n" +
            "5877 8220\n" +
            "6002 2516\n" +
            "1060 5844\n" +
            "428 196\n" +
            "6637 8077\n" +
            "1117 1083\n" +
            "10000 9999\n" +
            "3775 730\n" +
            "9144 3997\n" +
            "871 8216\n" +
            "5749 1825\n" +
            "2551 8351\n" +
            "2546 9351\n" +
            "6652 6990\n" +
            "4734 9999\n" +
            "9432 3502\n" +
            "3148 9206\n" +
            "2080 3975\n" +
            "5245 2476\n" +
            "9940 9107\n" +
            "1 10000\n" +
            "2916 5600\n" +
            "7974 7050\n" +
            "7879 4016\n" +
            "8746 9615\n" +
            "3732 4362\n" +
            "8500 8309\n" +
            "3547 1833\n" +
            "8850 8039\n" +
            "9819 8658\n" +
            "8186 775\n" +
            "1260 1199\n" +
            "4183 4424\n" +
            "9780 9297\n" +
            "6090 8340\n" +
            "1404 783\n" +
            "7277 462\n" +
            "5050 6026\n" +
            "5560 4406\n" +
            "9495 8100\n" +
            "3942 3874\n" +
            "2416 9818\n" +
            "1519 2321\n" +
            "9623 800\n" +
            "2557 8865\n" +
            "8609 2923\n" +
            "217 3216\n" +
            "2584 3886\n" +
            "5358 1172\n" +
            "6216 6087\n" +
            "5522 8741\n" +
            "9324 609\n" +
            "7258 8360\n" +
            "6808 3450\n" +
            "9437 2444\n" +
            "4534 1845\n" +
            "8534 5799\n" +
            "7228 3919\n" +
            "693 9128\n" +
            "2938 9292\n" +
            "8412 9028\n" +
            "5270 4065\n" +
            "2964 7835\n" +
            "2738 617\n" +
            "8663 8201\n" +
            "6347 4411\n" +
            "4390 2672\n" +
            "2746 4816\n" +
            "9978 2451\n" +
            "5165 5111\n" +
            "7933 3331\n" +
            "7828 5963\n" +
            "3937 9332\n" +
            "8550 8849\n" +
            "9829 3375\n" +
            "9268 501\n" +
            "8846 8184\n" +
            "9203 3284\n" +
            "7410 3454\n" +
            "7748 9530\n" +
            "1940 4344\n" +
            "5053 2875\n" +
            "2924 4436\n" +
            "9640 9556\n" +
            "4294 4280\n" +
            "1177 401\n" +
            "9457 3620\n" +
            "290 2318\n" +
            "3183 4964\n" +
            "4920 4481\n" +
            "9050 6560\n" +
            "4773 7772\n" +
            "9835 3301\n" +
            "9654 1629\n" +
            "7459 3819\n" +
            "1485 2680\n" +
            "5412 7816\n" +
            "1295 6778\n" +
            "3974 3722\n" +
            "1357 9829\n" +
            "5141 2774\n" +
            "1052 8025\n" +
            "4335 7477\n" +
            "7215 7855\n" +
            "9993 3100\n" +
            "2793 1998\n" +
            "7393 8098\n" +
            "6694 5528\n" +
            "43 500\n" +
            "9025 8763\n" +
            "2095 5522\n" +
            "2902 9203\n" +
            "7223 9216\n" +
            "3416 3493\n" +
            "9235 5368\n" +
            "4097 4252\n" +
            "6839 9013\n" +
            "9847 373\n" +
            "1513 2920\n" +
            "7283 1204\n" +
            "1862 6533\n" +
            "4938 9736\n" +
            "5052 6717\n" +
            "3958 7577\n" +
            "9983 8051\n" +
            "5564 503\n" +
            "5454 1073\n" +
            "405 7923\n" +
            "1829 8227\n" +
            "3912 4549\n" +
            "5324 8832\n" +
            "4212 5359\n" +
            "7860 4158\n" +
            "7769 919\n" +
            "782 8652\n" +
            "9326 4312\n" +
            "7742 6672\n" +
            "7505 1647\n" +
            "5762 2833\n" +
            "9341 5111\n" +
            "6782 6077\n" +
            "9133 3511\n" +
            "7521 4066\n" +
            "4716 8209\n" +
            "6375 8982\n" +
            "127 5091\n" +
            "2703 8417\n" +
            "4135 2232\n" +
            "2525 5288\n" +
            "2874 3286\n" +
            "2855 3458\n" +
            "7256 1040\n" +
            "3665 1772\n" +
            "1800 1835\n" +
            "8947 2711\n" +
            "5467 3475\n" +
            "8720 8543\n" +
            "2518 5605\n" +
            "2431 1708\n" +
            "8706 116\n" +
            "548 5163\n" +
            "9789 4646\n" +
            "7222 1579\n" +
            "7985 8175\n" +
            "8768 4331\n" +
            "1138 4715\n" +
            "2291 2736\n" +
            "2138 2869\n" +
            "8584 7241\n" +
            "2974 7485\n" +
            "1648 9694\n" +
            "6881 6324\n" +
            "6694 5106\n" +
            "3350 1448\n" +
            "8169 6895\n" +
            "7632 7316\n" +
            "3492 2369\n" +
            "8243 8359\n" +
            "6576 7159\n" +
            "1194 2034\n" +
            "2215 2831\n" +
            "850 5292\n" +
            "2497 808\n" +
            "883 1128\n" +
            "9994 1872\n" +
            "4332 4932\n" +
            "8519 4350\n" +
            "1973 7002\n" +
            "6214 1735\n" +
            "2877 7088\n" +
            "637 6836\n" +
            "4596 1330\n" +
            "8200 1584\n" +
            "3984 5988\n" +
            "9150 9844\n" +
            "8115 8811\n" +
            "8034 8252\n" +
            "9216 2795\n" +
            "340 7073\n" +
            "7555 9296\n" +
            "3615 8304\n" +
            "1025 5896\n" +
            "7834 9024\n" +
            "2290 8933\n" +
            "8410 6317\n" +
            "2732 3958\n" +
            "7821 6121\n" +
            "1088 60\n" +
            "2743 9872\n" +
            "1589 4679\n" +
            "2870 8706\n" +
            "5714 2425\n" +
            "3311 371\n" +
            "5063 8312\n" +
            "9457 7084\n" +
            "2835 1238\n" +
            "6711 6329\n" +
            "5356 946\n" +
            "9249 1746\n" +
            "3685 4462\n" +
            "1561 8589\n" +
            "929 2873\n" +
            "3088 4264\n" +
            "2747 9564\n" +
            "8881 7218\n" +
            "5552 4959\n" +
            "6354 8201\n" +
            "5809 1340\n" +
            "6984 651\n" +
            "7828 8081\n" +
            "1946 5239\n" +
            "6786 5896\n" +
            "8235 7587\n" +
            "3480 9800\n" +
            "6802 6398\n" +
            "4471 244\n" +
            "4564 3437\n" +
            "8102 3729\n" +
            "958 857\n" +
            "294 978\n" +
            "9222 3453\n" +
            "7219 973\n" +
            "8833 7402\n" +
            "2367 941\n" +
            "9908 1636\n" +
            "1105 4728\n" +
            "2982 4628\n" +
            "9088 7904\n" +
            "4218 4103\n" +
            "7698 1796\n" +
            "9151 4011\n" +
            "8273 3855\n" +
            "3161 9599\n" +
            "4499 342\n" +
            "9032 4106\n" +
            "9599 124\n" +
            "2758 3793\n" +
            "9085 1479\n" +
            "6620 764\n" +
            "2741 5762\n" +
            "787 6487\n" +
            "5796 2492\n" +
            "357 4114\n" +
            "3037 6205\n" +
            "4076 8283\n" +
            "1396 9118\n" +
            "7567 2698\n" +
            "8634 6255\n" +
            "250 3194\n" +
            "2518 4145\n" +
            "1597 3909\n" +
            "3152 3372\n" +
            "4330 9070\n" +
            "2726 6391\n" +
            "7713 7591\n" +
            "8130 2885\n" +
            "3174 3818\n" +
            "8263 7229\n" +
            "3551 3786\n" +
            "9313 7664\n" +
            "3609 153\n" +
            "645 1868\n" +
            "9474 5490\n" +
            "6947 4253\n" +
            "110 5727\n" +
            "7409 8184\n" +
            "9485 241\n" +
            "4592 3777\n" +
            "7929 269\n" +
            "4871 2468\n" +
            "9426 5107\n" +
            "6118 8614\n" +
            "9308 4255\n" +
            "7178 2179\n" +
            "9357 274\n" +
            "6213 759\n" +
            "2 9889\n" +
            "9365 1000\n" +
            "377 7499\n" +
            "3986 5040\n" +
            "6638 9548\n" +
            "6571 893\n" +
            "2984 9926\n" +
            "4408 6243\n" +
            "6931 3221\n" +
            "1631 5855\n" +
            "758 9384\n" +
            "1673 8795\n" +
            "9973 8414\n" +
            "8131 9199\n" +
            "9950 900\n" +
            "9952 1052\n" +
            "3285 977\n" +
            "8556 4081\n" +
            "5466 757\n" +
            "1145 2192\n" +
            "4576 4931\n" +
            "3484 6320\n" +
            "7695 1709\n" +
            "1702 6826\n" +
            "7561 8374\n" +
            "5502 7078\n" +
            "1790 5111\n" +
            "4379 8430\n" +
            "1409 5917\n" +
            "1796 6296\n" +
            "1658 7831\n" +
            "1290 7326\n" +
            "6644 2363\n" +
            "6907 5599\n" +
            "9247 4144\n" +
            "2199 7365\n" +
            "2590 1227\n" +
            "1780 2359\n" +
            "1136 7716\n" +
            "4964 7663\n" +
            "4657 2096\n" +
            "4292 3283\n" +
            "7752 1359\n" +
            "5437 6438\n" +
            "4936 4382\n" +
            "3996 6326\n" +
            "8658 1852\n" +
            "1444 5373\n" +
            "879 7534\n" +
            "1721 2355\n" +
            "144 7693\n" +
            "540 4672\n" +
            "1423 2941\n" +
            "1012 5364\n" +
            "909 7157\n" +
            "7065 6809\n" +
            "4749 8604\n" +
            "2265 1229\n" +
            "7958 6585\n" +
            "4198 4515\n" +
            "1491 200\n" +
            "1708 2529\n" +
            "5276 9361\n" +
            "6709 3442\n" +
            "9404 6434\n" +
            "3382 6835\n" +
            "2427 9747\n" +
            "7713 536\n" +
            "8740 8191\n" +
            "1275 4230\n" +
            "302 1392\n" +
            "5262 5400\n" +
            "908 8961\n" +
            "8766 8061\n" +
            "7407 4627\n" +
            "630 3350\n" +
            "8929 6451\n" +
            "3450 6762\n" +
            "4690 2448\n" +
            "8997 7628\n" +
            "3253 9552\n" +
            "1194 7609\n" +
            "754 1106\n" +
            "1341 2997\n" +
            "1283 6251\n" +
            "1817 3005\n" +
            "8145 9163\n" +
            "1425 1493\n" +
            "6127 8383\n" +
            "7754 7305\n" +
            "9947 3407\n" +
            "4549 4406\n" +
            "3187 9063\n" +
            "7968 8264\n" +
            "1227 4744\n" +
            "6372 6411\n" +
            "377 831\n" +
            "4078 7629\n" +
            "9164 7650\n" +
            "9968 8551\n" +
            "950 2704\n" +
            "5807 1890\n" +
            "3728 4064\n" +
            "7508 7222\n" +
            "9781 3239\n" +
            "5342 8107\n" +
            "7275 3764\n" +
            "924 8067\n" +
            "8583 117\n" +
            "2317 7659\n" +
            "64 7802\n" +
            "2282 5887\n" +
            "6809 759\n" +
            "1569 3461\n" +
            "7545 3644\n" +
            "9986 1471\n" +
            "4021 4054\n" +
            "8492 8164\n" +
            "9650 5070\n" +
            "7686 1413\n" +
            "1094 1743\n" +
            "24 5994\n" +
            "2238 4154\n" +
            "6338 5101\n" +
            "6359 2004\n" +
            "5170 420\n" +
            "4759 8788\n" +
            "8256 4769\n" +
            "7963 512\n" +
            "9819 363\n" +
            "6706 4199\n" +
            "8172 5716\n" +
            "1622 2190\n" +
            "5736 259\n" +
            "5664 4309\n" +
            "5144 1202\n" +
            "2674 2193\n" +
            "7378 2343\n" +
            "1068 650\n" +
            "5759 7892\n" +
            "8298 1804\n" +
            "885 7169\n" +
            "258 4256\n" +
            "3509 9152\n" +
            "4641 8115\n" +
            "1901 3366\n" +
            "5301 3115\n" +
            "2917 94\n" +
            "35 1847\n" +
            "5323 9223\n" +
            "5904 2990\n" +
            "4056 9875\n" +
            "1745 8108\n" +
            "4899 448\n" +
            "2845 4939\n" +
            "772 5673\n" +
            "2640 9214\n" +
            "1368 8148\n" +
            "121 3373\n" +
            "8801 7516\n" +
            "1026 974\n" +
            "2197 7958\n" +
            "8836 6505\n" +
            "9997 4566\n" +
            "8618 145\n" +
            "6117 1257\n" +
            "9124 8239\n" +
            "7608 6106\n" +
            "9452 1785\n" +
            "6163 4687\n" +
            "4802 4861\n" +
            "9343 595\n" +
            "3938 5776\n" +
            "1978 4980\n" +
            "9290 5924\n" +
            "7349 5725\n" +
            "9919 5347\n" +
            "4245 1475\n" +
            "2735 5631\n" +
            "8572 7938\n" +
            "5422 5820\n" +
            "903 2871\n" +
            "2691 2266\n" +
            "7207 9646\n" +
            "4250 7206\n" +
            "2667 7819\n" +
            "1786 7872\n" +
            "2290 2890\n" +
            "9662 2188\n" +
            "1388 370\n" +
            "4327 7075\n" +
            "6448 1492\n" +
            "1966 4410\n" +
            "2732 4334\n" +
            "8268 7143\n" +
            "2651 5636\n" +
            "1340 7529\n" +
            "6776 3267\n" +
            "1125 8431\n" +
            "8342 703\n" +
            "8515 9973\n" +
            "6522 9757\n" +
            "7493 509\n" +
            "8349 3711\n" +
            "2366 6994\n" +
            "5420 8476\n" +
            "3175 380\n" +
            "8010 1143\n" +
            "9737 9185\n" +
            "9993 9935\n" +
            "9983 9909\n" +
            "9980 9985\n" +
            "9959 9926\n" +
            "9927 9929\n" +
            "9984 9957\n" +
            "9976 9927\n" +
            "9975 9994\n" +
            "9994 9929\n" +
            "9923 9941\n" +
            "9966 9953\n" +
            "9948 9927\n" +
            "9963 9961\n" +
            "9978 9986\n" +
            "9946 9965\n" +
            "9964 9910\n" +
            "9981 9991\n" +
            "9954 9959\n" +
            "9900 9943\n" +
            "9920 9979\n" +
            "9938 9969\n" +
            "9919 9942\n" +
            "9974 9997\n" +
            "9947 9970\n" +
            "9984 9979\n" +
            "9914 9990\n" +
            "9965 9972\n" +
            "9993 9910\n" +
            "9921 9981\n" +
            "9981 9999\n" +
            "9921 9998\n" +
            "9968 9945\n" +
            "9903 9951\n" +
            "9976 9915\n" +
            "9938 9904\n" +
            "9997 9972\n" +
            "9918 9933\n" +
            "9902 9932\n" +
            "9941 9905\n" +
            "9998 9949\n" +
            "9911 9974\n" +
            "10000 9931\n" +
            "9933 9918\n" +
            "9979 9944\n" +
            "9967 9947\n" +
            "10000 10000\n" +
            "9939 9989\n" +
            "9959 9902\n" +
            "9975 9900\n" +
            "9927 9981\n" +
            "9978 9921\n" +
            "9935 9908\n" +
            "9942 9954\n" +
            "9931 9988\n" +
            "9980 9933\n" +
            "9948 9942\n" +
            "9954 9918\n" +
            "9903 9950\n" +
            "9970 9993\n" +
            "10000 9908\n" +
            "9988 9983\n" +
            "9957 9939\n" +
            "9907 9936\n" +
            "9913 9950\n" +
            "9996 9925\n" +
            "9956 9959\n" +
            "9978 9927\n" +
            "9979 10000\n" +
            "9995 9950\n" +
            "9967 9931\n" +
            "9967 9915\n" +
            "9917 9920\n" +
            "9908 9993\n" +
            "9995 9985\n" +
            "9907 9910\n" +
            "9909 9922\n" +
            "9983 9921\n" +
            "9901 9956\n" +
            "9970 9971\n" +
            "9910 9940\n" +
            "9956 9957\n" +
            "9942 9986\n" +
            "9963 9906\n" +
            "9974 9989\n" +
            "9998 9916\n" +
            "9944 9978\n" +
            "9914 9906\n" +
            "9909 9901\n" +
            "9984 9942\n" +
            "9968 9994\n" +
            "9973 9939\n" +
            "9990 9937\n" +
            "9981 9978\n" +
            "9962 9912\n" +
            "9955 9993\n" +
            "9946 9953\n" +
            "9940 9953\n" +
            "9940 9904\n" +
            "9957 9983\n" +
            "9923 9915\n";
}
