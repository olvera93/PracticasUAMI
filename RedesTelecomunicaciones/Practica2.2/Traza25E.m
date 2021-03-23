load h25.dat
load hop25.txt
hold on
sampleRTT = hop25
estimatedRTT = h25(:,1)
timeout = h25(:,2)
plot(sampleRTT, '-db', 'linewidth', 1)
plot(estimatedRTT, '-sr', 'linewidth', 1) 
plot(timeout, '-*k', 'linewidth', 1)
axis([197600, 197630, 0, 700])
xlabel("Número de vueltas")
ylabel("RTT[ms]")
title("Valor de α = 0.065 y  β = 0.10 con un error cuadrático medio = 199.5247")
subtitle("Traza 25 -- SET E")
MSE = mean((sampleRTT - estimatedRTT).^2);
legend({'sampleRTT', 'EstimatedRTT', 'TimeoutInterval'}, 'location', "northwestoutside")
grid on 