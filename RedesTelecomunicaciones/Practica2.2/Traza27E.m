load h27.dat
load hop27.txt
hold on
sampleRTT = hop27
estimatedRTT = h27(:,1)
timeout = h27(:,2)
plot(sampleRTT, '-d', 'linewidth', 1)
plot(estimatedRTT, '-sk', 'linewidth', 1)
plot(timeout, '-*r', 'linewidth', 1)
axis([230, 260, 0, 700])
xlabel("Número de vueltas")
ylabel("RTT[ms]")
title("Valor de α = 0.125 y  β = 0.25 con un error cuadrático medio = 194.8630")
subtitle("Traza 27 -- SET E")
MSE = mean((sampleRTT - estimatedRTT).^2);
legend({'sampleRTT', 'EstimatedRTT', 'TimeoutInterval'}, 'location', "northwestoutside")
grid on 