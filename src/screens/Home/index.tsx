import React, {useEffect} from 'react';
import {Text, Button} from 'react-native';
import {Container} from './styles';
import {useMetaMask} from '../../hooks/useMetamask';
import {WatchService} from '../../services/WatchService';
import {useSmartwatchScan} from '../../hooks/useSmartwatchScan';

export const Home = () => {
  const {walletAddress} = useMetaMask();
  const {devices} = useSmartwatchScan();

  useEffect(() => {
    console.log(devices);
  }, [devices]);

  return (
    <Container>
      <Text>{walletAddress}</Text>
      <Button title="Scan" onPress={() => WatchService.startScanDevices()} />
    </Container>
  );
};
