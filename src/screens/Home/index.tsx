import React from 'react';
import {Text} from 'react-native';
import {Container} from './styles';
import {useMetaMask} from '../../hooks/useMetamask';

export const Home = () => {
  const {walletAddress} = useMetaMask();

  return (
    <Container>
      <Text>{walletAddress}</Text>
    </Container>
  );
};
