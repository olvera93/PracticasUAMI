load h24.dat
load hop24.txt
hold on
sampleRTT = hop24
estimatedRTT = h24(:,1)
timeout = h24(:,2)
plot(sampleRTT, '--dr', 'linewidth', 1)
plot(estimatedRTT, '-sg', 'linewidth', 1) 
plot(timeout, '-*b', 'linewidth', 1)
axis([430, 460, 0, 400])
xlabel("Número de vueltas")
ylabel("RTT[ms]")
title("Valor de α = 0.9 y  β = 0.75 con un error cuadrático medio = 3.6741")
subtitle("Traza 24 -- SET E")
MSE = mean((sampleRTT - estimatedRTT).^2);
legend({'sampleRTT', 'EstimatedRTT', 'TimeoutInterval'}, 'location', "northwestoutside")
grid on 