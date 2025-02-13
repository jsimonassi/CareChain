import React from 'react';
import {Text, View} from 'react-native';
import {
  ConnectedText,
  Container,
  HomeContainer,
  RunningLogo,
  StyledMetamaskLogo,
  SubTitleText,
  TitleText,
  TopBar,
  TopBarLeftSide,
  TopBarRightSide,
  WalletText,
} from './styles';
import {useMetaMask} from '../../hooks/useMetamask';
import {Assets} from '../../assets/images';
import {AppButton} from '../../components/buttons/AppButton';

export const Home = () => {
  const {walletAddress} = useMetaMask();

  return (
    <Container>
      <TopBar>
        <TopBarLeftSide>
          <StyledMetamaskLogo source={Assets.metamaskLogo} />
        </TopBarLeftSide>
        {/* <Text>{walletAddress}</Text> */}
        <TopBarRightSide>
          <ConnectedText>You are connected</ConnectedText>
          <WalletText>1r2xxcnjhvbsdvad12...</WalletText>
        </TopBarRightSide>
      </TopBar>
      <HomeContainer>
        <RunningLogo source={Assets.SmartwatchRun} />
        <TitleText>Let's get started!</TitleText>
        <SubTitleText>Search for nearby devices</SubTitleText>
      </HomeContainer>
      <AppButton
        label="TESTE"
        backgroundColor="primaryColor"
        textColor="white"
      />
    </Container>
  );
};
