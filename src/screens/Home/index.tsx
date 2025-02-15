import React from 'react';
import {
  Container,
  HomeContainer,
  RunningLogo,
  SubTitleText,
  TitleText,
} from './styles';
import {Assets} from '../../assets/images';
import {AppButton} from '../../components/buttons/AppButton';
import {TopBarComponent} from '../../components/TopBar';

export const Home = () => {
  return (
    <Container>
      <TopBarComponent />
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
