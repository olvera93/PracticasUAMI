function abs(v) {return v < 0 ? -v : v}

BEGIN {
    alpha = 0.125;
    beta = 0.25;
    k = 4
}

FNR == 1 {
    sampleRTT = $1;
    estimatedRTT = sampleRTT;
    devRTT = sampleRTT/2;
    timeoutInterval = estimatedRTT + (k*devRTT)
}


FNR > 1 {
    sampleRTT = $1;
    devRTT = (1-beta) * (devRTT) + (beta) * (abs(sampleRTT - estimatedRTT));
    estimatedRTT = ((1-alpha) * estimatedRTT) + (alpha * sampleRTT);
    timeoutInterval = estimatedRTT + (k*devRTT)
}

{print "\t\t\n",estimatedRTT,timeoutInterval}
